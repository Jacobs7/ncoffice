package com.dape.cms.web.controller;

import com.alibaba.dubbo.config.support.Parameter;
import com.alibaba.fastjson.JSON;
import com.dape.cms.common.constant.CmsResult;
import com.dape.cms.common.constant.CmsResultConstant;
import com.dape.cms.dao.model.*;
import com.dape.common.base.BaseController;
import com.dape.common.util.JmsUtil;
import com.dape.common.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.dape.common.base.BaseController.thymeleaf;

@Controller
@RequestMapping(value = "/cms")
public class CmsController extends BaseController {

    //MQ 消息发送者
    @Autowired JmsTemplate jmsTemplate;

    @Qualifier("defaultQueueDestination")
    @Autowired Destination destination;

    /**********************
     * 用户登陆页面跳转
     * ********************/
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String login(Model model) {
        return thymeleaf("/user/login");
    }

    /**********************
     * 用户注册页面跳转
     * ********************/
    @RequestMapping(value = "reg", method = RequestMethod.GET)
    public String reg(Model model) {
        return thymeleaf("/user/reg");
    }

    /**********************
     * 用户登陆验证
     * ********************/
    @RequestMapping(value = "/checkUserLogin", method = RequestMethod.POST)
    @ResponseBody
    public void checkUserLogin(HttpServletRequest request, HttpServletResponse response, Model model){

        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        Map loginUser = new HashMap();
        loginUser.put("username",userName);
        loginUser.put("pwd",password);

        JmsUtil.sendMessage(jmsTemplate,destination, JSON.toJSONString(loginUser));

        System.out.println("controller中进入  JSON字符串    --->"+JSON.toJSONString(loginUser));

        String allStr = RedisUtil.get("*");

        System.out.println("我是从redis 中读取的消息:"+allStr);

        //return new CmsResult(CmsResultConstant.SUCCESS, 0);
    }
}
