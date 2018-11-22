package com.dape.shop.web.controller;

import com.dape.common.base.BaseController;
import com.dape.shop.dao.model.*;
import com.dape.shop.rpc.api.ShopGoodsService;
import com.dape.shop.rpc.api.ShopMenuService;
import com.dape.shop.rpc.api.ShopModuleService;
import com.dape.shop.rpc.api.ShopUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 首页控制器
 * ncoffice on 2018/11/20.
 */
@Controller
@RequestMapping("user")
public class ShopUserController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShopUserController.class);

    @Autowired
    ShopUserService shopUserService;

    @RequestMapping(value = "/mine", method = RequestMethod.GET)
    public String mine(Model model) {

        return thymeleaf("/mine");
    }
}
