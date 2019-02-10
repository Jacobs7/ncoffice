package com.dape.shop.web.controller;

import com.dape.common.base.BaseController;
import com.dape.common.util.MD5Util;
import com.dape.common.util.RamdonUtil;
import com.dape.common.util.RedisUtil;
import com.dape.shop.common.constant.ShopSmsStatusEnum;
import com.dape.shop.dao.model.*;
import com.dape.shop.rpc.api.ShopSmsService;
import com.dape.shop.rpc.api.ShopUserService;
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
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
    private ShopUserService shopUserService;

    @Autowired
    public ShopSmsService shopSmsService;

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
        ShopUser shopUser = null;

        if(type.equals("pwd")){
            upmsUser = shopUserService.selectUpmsUserByUsername(username);
            if(MD5Util.md5(password + upmsUser.getSalt()).equals(upmsUser.getPassword())){// 验证密码
                ShopUserExample shopUserExample = new ShopUserExample();
                shopUserExample.or().andUserIdEqualTo(upmsUser.getUserId());
                shopUser = shopUserService.selectFirstByExample(shopUserExample);
            }else{
                result.put("msg", "密码错误");
                return result;
            }
        }else if(type.equals("sms")){ // 手机号直接登录：验证码验证通过，自动登录，并设置新密码
            // 验证码校验
            ShopSmsExample shopSmsE = new ShopSmsExample();
            shopSmsE.or().andNewMobileEqualTo(username).andStatusEqualTo(ShopSmsStatusEnum.UNUSED.getCode());
            ShopSms shopSms = shopSmsService.selectFirstByExample(shopSmsE);
            if(shopSms != null && shopSms.getSmsCode().equals(smscode)){
                long time = System.currentTimeMillis() - shopSms.getCreateDate().getTime();
                shopSms.setStatus(ShopSmsStatusEnum.ISUSED.getCode());
                shopSmsService.updateByPrimaryKey(shopSms);// 更新验证码状态为已使用
                if(time > 5 * 60 * 1000){// 已超时，5分钟
                    result.put("msg", "验证码已失效");
                    return result;
                }else{
                    // 验证码验证成功，更新密码
                    upmsUser = shopUserService.selectUpmsUserByUsername(username);
                    if(upmsUser == null){// 未查到时，新增用户
                        UpmsUser newUser = new UpmsUser();
                        String salt = UUID.randomUUID().toString().replaceAll("-", "");
                        newUser.setUsername(username);
                        newUser.setSalt(salt);
                        newUser.setPassword(MD5Util.md5(newpassword + salt));
                        newUser.setCtime(System.currentTimeMillis());
                        newUser.setLocked((byte)0);
                        newUser.setPhone(username);
                        upmsUser = shopUserService.createUser(newUser);

                        shopUser = new ShopUser();
                        shopUser.setUserId(upmsUser.getUserId());
                        shopUser.setWeiNickName(username);
//                        shopUser.setHeadUrl(headUrl);
                        // 获取6位推荐码，查询数据库，推荐码存在，就重新获取
                        String code = null;
                        while(true){
                            code = RamdonUtil.getSixCode();
                            ShopUserExample userExample = new ShopUserExample();
                            userExample.or().andRCodeEqualTo(code);
                            int count = shopUserService.countByExample(userExample);
                            if(count <= 0){
                                break;
                            }
                        }
                        shopUser.setrCode(code);
                        shopUser.setOutCash(0);
                        shopUser.setMoney(0);
                        short rank = 1;
                        shopUser.setRank(rank);
                        shopUserService.insert(shopUser);
                    }
                }
            }else{
                result.put("msg", "验证码错误");
                shopSms.setStatus(ShopSmsStatusEnum.ISUSED.getCode());
                shopSmsService.updateByPrimaryKey(shopSms);// 更新验证码状态为已使用
                return result;
            }
        }

        request.getSession().setAttribute("user", upmsUser);
        request.getSession().setAttribute("shopUser", shopUser);
        result.put("success", true);
        return result;
    }
}
