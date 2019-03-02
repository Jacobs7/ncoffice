package com.dape.pay.web.controller;


import com.alibaba.fastjson.JSON;
import com.dape.common.base.BaseController;
import com.dape.common.util.JmsUtil;
import com.dape.pay.common.constant.PayResult;
import com.dape.pay.common.constant.PayResultConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.Destination;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 支付宝
 * Created by ZhangShuzheng on 2017/04/04.
 */
@Controller
@RequestMapping("login")
public class LoginController extends BaseController {

    //MQ 消息发送者
    @Autowired
    JmsTemplate jmsTemplate;

    @Qualifier("defaultQueueDestination")
    @Autowired
    Destination destination;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, HttpServletRequest request) {
        return thymeleaf("/user/login");
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model, HttpServletRequest request) {
        return thymeleaf("/user/register");
    }

    /**
     * 用户登录验证
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/checkUserLogin", method = RequestMethod.POST)
    @ResponseBody
    public Object checkUserLogin(HttpServletRequest request, HttpServletResponse response, Model model){

        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        Map loginUser = new HashMap();
        loginUser.put("username",userName);
        loginUser.put("pwd",password);

        JmsUtil.sendMessage(jmsTemplate,destination, JSON.toJSONString(loginUser));
        System.out.println("controller中进入  JSON字符串    --->"+JSON.toJSONString(loginUser));

        return new PayResult(PayResultConstant.SUCCESS, 0);
    }
}