package com.dape.shop.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

import static com.dape.common.base.BaseController.thymeleaf;

/**
 * 首页控制器
 * ncoffice on 2018/11/20.
 */
@Controller
@RequestMapping("userInfo")
public class ShopOrderController {

    /**
     * 转向最近订单页
     * @param tab
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/toOrders", method = RequestMethod.GET)
    public String toFrends(Integer tab, Model model, HttpServletRequest request) {
        if(tab == null){
            model.addAttribute("tab", 1);
        }else{
            model.addAttribute("tab", tab);
        }
        return thymeleaf("/orders");
    }


}
