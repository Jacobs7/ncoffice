package com.dape.bc.web.controller;

import com.dape.bc.dao.model.UpmsUser;
import com.dape.bc.rpc.api.BcSmsService;
import com.dape.bc.rpc.api.UpmsUserService;
import com.dape.common.base.BaseController;
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
public class UserController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UpmsUserService upmsUserService;
    @Autowired
    public BcSmsService bcSmsService;

    @RequestMapping(value = "/mine", method = RequestMethod.GET)
    public String mine(Model model, HttpServletRequest request) {

        Object o = request.getSession().getAttribute("upmsuser");
        UpmsUser upmsUser = null;
        if(o != null){
            upmsUser = (UpmsUser)o;
        }
        request.getSession().setAttribute("upmsuser", upmsUser); // 更新session
        model.addAttribute("upmsuser", upmsUser);

        return thymeleaf("/mine");
    }
}
