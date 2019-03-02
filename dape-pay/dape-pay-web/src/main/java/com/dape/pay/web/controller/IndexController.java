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
public class IndexController extends BaseController {

    //MQ 消息发送者
    @Autowired
    JmsTemplate jmsTemplate;

    @Qualifier("defaultQueueDestination")
    @Autowired
    Destination destination;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
        return thymeleaf("/index");
    }

}