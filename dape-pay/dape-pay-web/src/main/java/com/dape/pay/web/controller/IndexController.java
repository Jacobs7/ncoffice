package com.dape.pay.web.controller;


import com.dape.common.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * 支付宝
 * Created by ZhangShuzheng on 2017/04/04.
 */
@Controller
public class IndexController extends BaseController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {

        return thymeleaf("/index");
    }
}