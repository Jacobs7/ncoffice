package com.dape.shop.web.controller;

import com.dape.common.base.BaseController;
import com.dape.shop.dao.model.*;
import com.dape.shop.rpc.api.ShopUserInfoService;
import com.dape.shop.rpc.api.ShopUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping(value = "/mine", method = RequestMethod.GET)
    public String mine(Model model, HttpServletRequest request) {
        ShopUser user = new ShopUser();
        ShopUserInfo userInfo = new ShopUserInfo();

        Object o = request.getSession().getAttribute("openId");
        if(o != null){
            ShopUserExample userExample = new ShopUserExample();
            userExample.or().andOpenIdEqualTo(o.toString());
            user = shopUserService.selectFirstByExample(userExample);

            if(user != null){
                ShopUserInfoExample userInfoExample = new ShopUserInfoExample();
                userInfoExample.or().andShopUserIdEqualTo(user.getId());
                userInfo =shopUserInfoService.selectFirstByExample(userInfoExample);
            }
        }
        request.getSession().setAttribute("user", user); // 更新session
        model.addAttribute("user", user);
        model.addAttribute("userInfo", userInfo);

        return thymeleaf("/mine");
    }
}
