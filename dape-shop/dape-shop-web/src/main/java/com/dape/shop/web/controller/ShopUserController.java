package com.dape.shop.web.controller;

import com.dape.common.base.BaseController;
import com.dape.shop.common.constant.ShopCashStatusEnum;
import com.dape.shop.common.constant.ShopCashTypeEnum;
import com.dape.shop.common.constant.ShopPayTypeEnum;
import com.dape.shop.common.constant.ShopSmsStatusEnum;
import com.dape.shop.dao.model.*;
import com.dape.shop.rpc.api.ShopCashFlowService;
import com.dape.shop.rpc.api.ShopSmsService;
import com.dape.shop.rpc.api.ShopUserInfoService;
import com.dape.shop.rpc.api.ShopUserService;
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
@RequestMapping("user")
public class ShopUserController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShopUserController.class);

    @Autowired
    public ShopUserService shopUserService;
    @Autowired
    public ShopUserInfoService shopUserInfoService;
    @Autowired
    public ShopCashFlowService shopCashFlowService;
    @Autowired
    public ShopSmsService shopSmsService;

    @RequestMapping(value = "/mine", method = RequestMethod.GET)
    public String mine(Model model, HttpServletRequest request) {
        ShopUser user = new ShopUser();

        Object o = request.getSession().getAttribute("openId");
        if(o != null){
            ShopUserExample userExample = new ShopUserExample();
            userExample.or().andOpenIdEqualTo(o.toString());
            user = shopUserService.selectFirstByExample(userExample);
        }
        request.getSession().setAttribute("user", user); // 更新session
        model.addAttribute("user", user);

        return thymeleaf("/mine");
    }

    /**
     * 转向好友列表
     * @param frendTab
     * @param frendItem
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/toFrends", method = RequestMethod.GET)
    public String toFrends(Integer frendTab, Integer frendItem, Model model, HttpServletRequest request) {
        if(frendTab == null){
            model.addAttribute("frendTab", 1);
        }else{
            model.addAttribute("frendTab", frendTab);
        }
        if(frendItem == null){
            model.addAttribute("frendItem", 1);
        }else{
            model.addAttribute("frendItem", frendItem);
        }
        return thymeleaf("/frends");
    }

    /**
     * 查询好友列表数据
     * @param frendTab
     * @param frendItem
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/frends", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> frends(Integer pageNum, Integer pageSize, Integer frendTab, Integer frendItem, Model model, HttpServletRequest request) {
        if(frendTab == null){
            model.addAttribute("frendTab", 1);
        }else{
            model.addAttribute("frendTab", frendTab);
        }
        if(frendItem == null){
            model.addAttribute("frendItem", 1);
        }else{
            model.addAttribute("frendItem", frendItem);
        }

        Object o = request.getSession().getAttribute("user");

        List<ShopUserOrder> frends = new ArrayList<ShopUserOrder>();
        int count = 0;
        if(o != null){
            ShopUser user = (ShopUser)o;
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("sCode", user.getrCode());
            frends = shopUserService.listUserOrder(params);
            count = shopUserService.listUserOrderCount(params);
        }

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("totalCount", count);
        result.put("data", frends);
        return result;
    }

    /**
     * 我的积分
     * @param model
     * @return
     */
    @RequestMapping(value = "/integral", method = RequestMethod.GET)
    public String integral(Model model, HttpServletRequest request) {
        ShopUser user = new ShopUser();
        Object o = request.getSession().getAttribute("user");
        if(o != null){
            user = (ShopUser)o;
        }
        model.addAttribute("user", user);
        return thymeleaf("/integral");
    }

    /**
     * 帐户余额
     * @param model
     * @return
     */
    @RequestMapping(value = "/cash", method = RequestMethod.GET)
    public String cash(Model model, HttpServletRequest request) {
        ShopUser user = new ShopUser();
        Object o = request.getSession().getAttribute("user");
        if(o != null){
            user = (ShopUser)o;
        }
        model.addAttribute("user", user);
        return thymeleaf("/cash");
    }

    /**
     * 转向提现页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/cashOut", method = RequestMethod.GET)
    public String cashOut(Model model, HttpServletRequest request) {
        ShopUser user = new ShopUser();
        Object o = request.getSession().getAttribute("user");
        if(o != null){
            user = (ShopUser)o;
        }
        model.addAttribute("user", user);
        return thymeleaf("/cashOut");
    }

    /**
     * 积分兑换
     * @param integral
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/integralPostal", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> integralPostal(Integer integral, Model model, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", false);
        Object o = request.getSession().getAttribute("user");
        if(o != null){
            int dw100 = 100; // 满100分可兑换

            if(integral < dw100){
                result.put("msg", "满1000分才可兑换");
            }else{
                ShopUser user = (ShopUser)o;
                ShopUserExample shopUserE = new ShopUserExample();
                shopUserE.or().andIdEqualTo(user.getId());
                user = shopUserService.selectFirstByExample(shopUserE);
                if(integral > user.getIntegral()){
                    result.put("msg", "积分不足");
                }else{
                    user.setIntegral(user.getIntegral() - integral);
                    int u = shopUserService.updateByPrimaryKey(user);
                    if(u > 0){
                        ShopCashFlow shopCashFlow = new ShopCashFlow();
                        shopCashFlow.setUserId(user.getId());
                        shopCashFlow.setCreateDate(new Date());
                        shopCashFlow.setNum(integral);
                        shopCashFlow.setType(ShopCashTypeEnum.DUIHUAN.getCode());
                        shopCashFlow.setStatus(ShopCashStatusEnum.CHULIZHONG.getCode());
                        shopCashFlow.setRemark("积分兑换");
                        int r = shopCashFlowService.insert(shopCashFlow);
                        if(r > 0){
                            result.put("success", true);
                            request.getSession().setAttribute("user", user); // 更新session
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * 查询好友列表数据
     * @param money
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/cashPostal", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> cashPostal(String money, Model model, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", false);
        Object o = request.getSession().getAttribute("user");
        if(o != null){
            float moneyT = Float.valueOf(money);
            int cash = (int)(moneyT * 100);
            if(cash < 1){
                result.put("msg", "满1元才可提现");
            }else{
                ShopUser user = (ShopUser)o;
                ShopUserExample shopUserE = new ShopUserExample();
                shopUserE.or().andIdEqualTo(user.getId());
                user = shopUserService.selectFirstByExample(shopUserE);
                if(cash > user.getMoney()){
                    result.put("msg", "余额不足");
                }else{
                    user.setMoney(user.getMoney() - cash);
                    user.setOutCash(user.getOutCash() + cash);
                    int u = shopUserService.updateByPrimaryKey(user);
                    if(u > 0){
                        ShopCashFlow shopCashFlow = new ShopCashFlow();
                        shopCashFlow.setUserId(user.getId());
                        shopCashFlow.setCreateDate(new Date());
                        shopCashFlow.setNum(cash);
                        shopCashFlow.setType(ShopCashTypeEnum.TIXIAN.getCode());
                        shopCashFlow.setStatus(ShopCashStatusEnum.CHULIZHONG.getCode());
                        shopCashFlow.setRemark("用户提现");
                        int r = shopCashFlowService.insert(shopCashFlow);
                        if(r > 0){
                            result.put("success", true);
                            request.getSession().setAttribute("user", user); // 更新session
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * 个人设置
     * @param model
     * @return
     */
    @RequestMapping(value = "/toSetting", method = RequestMethod.GET)
    public String toSetting(Model model, HttpServletRequest request) {
        ShopUser user = new ShopUser();
        Object o = request.getSession().getAttribute("user");
        ShopUserInfo userInfo = new ShopUserInfo();
        if(o != null){
            user = (ShopUser)o;
            ShopUserInfoExample shopUserInfoE = new ShopUserInfoExample();
            shopUserInfoE.or().andShopUserIdEqualTo(user.getId());
            userInfo = shopUserInfoService.selectFirstByExample(shopUserInfoE);
        }
        model.addAttribute("user", user);
        model.addAttribute("userInfo", userInfo);
        return thymeleaf("/setting");
    }

    /**
     * 手机号修改
     * @param model
     * @return
     */
    @RequestMapping(value = "/toSetMobile", method = RequestMethod.GET)
    public String toSetMobile(Model model, HttpServletRequest request) {
        ShopUser user = new ShopUser();
        Object o = request.getSession().getAttribute("user");
        if(o != null){
            user = (ShopUser)o;
        }
        model.addAttribute("user", user);
        return thymeleaf("/setMobile");
    }

    /**
     * 修改手机
     * @param mobile
     * @param smsCode
     * @param request
     * @return
     */
    @RequestMapping(value = "/setMobile", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> setMobile(String mobile, String smsCode, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", false);

        ShopUser user = new ShopUser();
        Object o = request.getSession().getAttribute("user");
        if(o != null){
            user = (ShopUser)o;

            ShopUserExample shopUserE = new ShopUserExample();
            shopUserE.or().andMobileEqualTo(mobile);
            int count = shopUserService.countByExample(shopUserE);
            if(count > 0){
                result.put("msg", "该手机号已被绑定");
            }else{

                ShopSmsExample shopSmsE = new ShopSmsExample();
                shopSmsE.or().andNewMobileEqualTo(mobile).andUserIdEqualTo(user.getId()).andStatusEqualTo(ShopSmsStatusEnum.UNUSED.getCode());
                ShopSms shopSms = shopSmsService.selectFirstByExample(shopSmsE);
                if(shopSms != null && shopSms.getSmsCode().equals(smsCode)){
                    long time = System.currentTimeMillis() - shopSms.getCreateDate().getTime();
                    shopSms.setStatus(ShopSmsStatusEnum.ISUSED.getCode());
                    shopSmsService.updateByPrimaryKey(shopSms);// 更新验证码状态为已使用
                    if(time > 5 * 60 * 1000){// 已超时，5分钟
                        result.put("msg", "验证码已失效");
                    }else{
                        shopUserE = new ShopUserExample();
                        shopUserE.or().andIdEqualTo(user.getId());
                        user = shopUserService.selectFirstByExample(shopUserE);
                        user.setMobile(mobile);
                        int c = shopUserService.updateByPrimaryKey(user);
                        if(c > 0){
                            result.put("success", true);
                            request.getSession().setAttribute("user", user); // 更新session
                        }
                    }
                }else{
                    result.put("msg", "验证码错误");
                }
            }
        }

        return result;
    }

    /**
     * 手机号修改
     * @param model
     * @return
     */
    @RequestMapping(value = "/toSetZFB", method = RequestMethod.GET)
    public String toSetZFB(Model model, HttpServletRequest request) {
        ShopUser user = new ShopUser();
        Object o = request.getSession().getAttribute("user");
        if(o != null){
            user = (ShopUser)o;
        }
        model.addAttribute("user", user);
        return thymeleaf("/setZhifubao");
    }

    /**
     * 修改手机
     * @param zfbAccount
     * @param zfbName
     * @param request
     * @return
     */
    @RequestMapping(value = "/setZhifubao", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> setZhifubao(String zfbAccount, String zfbName, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", false);

        ShopUser user = new ShopUser();
        Object o = request.getSession().getAttribute("user");
        if(o != null){
            user = (ShopUser)o;

            ShopUserInfoExample shopUserInfoE = new ShopUserInfoExample();
            shopUserInfoE.or().andShopUserIdEqualTo(user.getId());
            ShopUserInfo info = shopUserInfoService.selectFirstByExample(shopUserInfoE);
            if(info == null){
                info = new ShopUserInfo();
                info.setShopUserId(user.getId());
                info.setZfbAccount(zfbAccount);
                info.setZfbName(zfbName);
                shopUserInfoService.insert(info);
            }else{
                info.setZfbAccount(zfbAccount);
                info.setZfbName(zfbName);
                shopUserInfoService.updateByExample(info,shopUserInfoE);
            }
            result.put("success", true);
        }
        return result;
    }

    /**
     * 设置支付方式
     * @param zfbAccount
     * @param zfbName
     * @param request
     * @return
     */
    @RequestMapping(value = "/setPayType", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> setPayType(Integer payType, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", false);

        ShopUser user = new ShopUser();
        Object o = request.getSession().getAttribute("user");
        if(o != null){
            user = (ShopUser)o;

            ShopUserInfoExample shopUserInfoE = new ShopUserInfoExample();
            shopUserInfoE.or().andShopUserIdEqualTo(user.getId());
            ShopUserInfo info = shopUserInfoService.selectFirstByExample(shopUserInfoE);
            if(info == null){
                info = new ShopUserInfo();
                info.setShopUserId(user.getId());
                info.setPayType(payType);
                shopUserInfoService.insert(info);
            }else{
                info.setPayType(payType);
                shopUserInfoService.updateByExample(info,shopUserInfoE);
            }
            result.put("success", true);
        }
        return result;
    }

    /**
     * 获取验证码
     * @param mobile
     * @param request
     * @return
     */
    @RequestMapping(value = "/sendSmsCode", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> sendSmsCode(String mobile, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", false);

        ShopUser user = new ShopUser();
        Object o = request.getSession().getAttribute("user");
        if(o != null){
            user = (ShopUser)o;

            ShopUserExample shopUserE = new ShopUserExample();
            shopUserE.or().andMobileEqualTo(mobile);
            int count = shopUserService.countByExample(shopUserE);
            if(count > 0){
                result.put("msg", "该手机号已被绑定");
            }else{
                // 发送验证码
                String code = "111111";
                // 待实现



                ShopSms shopSms = new ShopSms();
                shopSms.setUserId(user.getId());
                shopSms.setNewMobile(mobile);
                shopSms.setStatus(ShopSmsStatusEnum.ISUSED.getCode());
                shopSmsService.updateSmsCodeStatus(shopSms);// 修改之前的验证码为已使用状态

                shopSms.setCreateDate(new Date());
                shopSms.setOldMobile(user.getMobile() == null ? null : user.getMobile());
                shopSms.setSmsCode(code);
                shopSms.setStatus(ShopSmsStatusEnum.UNUSED.getCode());
                int c = shopSmsService.insert(shopSms);// 添加验证码到数据库
                if(c > 0){
                    result.put("success", true);
                }
            }
        }

        return result;
    }
}
