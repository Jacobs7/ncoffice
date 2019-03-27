package com.dape.bc.web.controller;

import com.dape.bc.common.constant.BcSmsStatusEnum;
import com.dape.bc.dao.model.BcSms;
import com.dape.bc.dao.model.BcSmsExample;
import com.dape.bc.dao.model.UpmsUser;
import com.dape.bc.dao.model.UpmsUserExample;
import com.dape.bc.rpc.api.BcSmsService;
import com.dape.bc.rpc.api.UpmsUserService;
import com.dape.common.base.BaseController;
import com.dape.common.util.MD5Util;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 首页控制器
 * ncoffice on 2018/11/20.
 */
@Controller
@RequestMapping("login")
public class LoginController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    private final static String DAPE_SHOP_WEB_SESSION_ID = "dape-shop-web-session-id";

    @Autowired
    private UpmsUserService upmsUserService;

    @Autowired
    public BcSmsService bcSmsService;

    /**
     * 转向登录页
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String toLogin(HttpServletRequest request) {

        return thymeleaf("/login");
    }

    /**
     * 帐号密码登录
     * @return
     */
    @RequestMapping(value = "/ajaxLogin", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> ajaxLogin(Model model, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", false);

        String username = request.getParameter("mobile");
        if (StringUtils.isBlank(username)) {
            result.put("msg", "手机号不能为空!");
            return result;
        }

        String password = request.getParameter("password");
        String smscode = request.getParameter("smscode");
        String newpassword = request.getParameter("newpassword");

        String type = request.getParameter("type");
        if(type != null && type.equals("pwd")){
            if (StringUtils.isBlank(password)) {
                result.put("msg", "密码不能为空!");
                return result;
            }
        }else if(type != null && type.equals("sms")){
            if (StringUtils.isBlank(smscode)) {
                result.put("msg", "验证码不能为空!");
                return result;
            }
            if (StringUtils.isBlank(newpassword)) {
                result.put("msg", "请输入新密码!");
                return result;
            }
        }else{
            result.put("msg", "参数错误!");
            return result;
        }

        UpmsUser upmsUser = null;

        if(type.equals("pwd")){
            UpmsUserExample ue = new UpmsUserExample();
            ue.or().andUsernameEqualTo(username);
            upmsUser = upmsUserService.selectFirstByExample(ue);
            if(upmsUser == null){
                result.put("msg", "用户不存在");
                return result;
            }else if(MD5Util.md5(password + upmsUser.getSalt()).equals(upmsUser.getPassword())){// 验证密码
                // 登录成功
            }else{
                result.put("msg", "密码错误");
                return result;
            }
        }else if(type.equals("sms")){ // 手机号直接登录：验证码验证通过，自动登录，并设置新密码
            // 验证码校验
            BcSmsExample bcSmsE = new BcSmsExample();
            bcSmsE.or().andNewMobileEqualTo(username).andStatusEqualTo(BcSmsStatusEnum.UNUSED.getCode());
            BcSms shopSms = bcSmsService.selectFirstByExample(bcSmsE);
            if(shopSms != null && shopSms.getSmsCode().equals(smscode)){
                long time = System.currentTimeMillis() - shopSms.getCreateDate().getTime();
                shopSms.setStatus(BcSmsStatusEnum.ISUSED.getCode());
                bcSmsService.updateByPrimaryKey(shopSms);// 更新验证码状态为已使用
                if(time > 5 * 60 * 1000){// 已超时，5分钟
                    result.put("msg", "验证码已失效");
                    return result;
                }else{
                    // 验证码验证成功，更新密码
                    UpmsUserExample ue = new UpmsUserExample();
                    ue.or().andUsernameEqualTo(username);
                    upmsUser = upmsUserService.selectFirstByExample(ue);
                    if(upmsUser == null){// 未查到时，新增用户
                        UpmsUser newUser = new UpmsUser();
                        String salt = UUID.randomUUID().toString().replaceAll("-", "");
                        newUser.setUsername(username);
                        newUser.setSalt(salt);
                        newUser.setPassword(MD5Util.md5(newpassword + salt));
                        newUser.setCtime(System.currentTimeMillis());
                        newUser.setLocked((byte)0);
                        newUser.setPhone(username);
                    }
                }
            }else{
                result.put("msg", "验证码错误");
                shopSms.setStatus(BcSmsStatusEnum.ISUSED.getCode());
                bcSmsService.updateByPrimaryKey(shopSms);// 更新验证码状态为已使用
                return result;
            }
        }

        request.getSession().setAttribute("upmsuser", upmsUser);
        result.put("success", true);
        return result;
    }
}
