package com.dape.bc.web.controller;

import com.dape.bc.common.constant.BcSmsStatusEnum;
import com.dape.bc.dao.model.BcSms;
import com.dape.bc.dao.model.BcSmsExample;
import com.dape.bc.dao.model.UpmsUser;
import com.dape.bc.dao.model.UpmsUserExample;
import com.dape.bc.rpc.api.BcSmsService;
import com.dape.bc.rpc.api.UpmsUserService;
import com.dape.common.base.BaseController;
import com.dape.common.util.MD5Util;
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
@RequestMapping("pay")
public class PayController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PayController.class);

    private final static String DAPE_SHOP_WEB_SESSION_ID = "dape-shop-web-session-id";

    /**
     * 转向登录页
     * @return
     */
    @RequestMapping(value = "/toPay", method = RequestMethod.GET)
    public String toLogin(HttpServletRequest request) {

        return thymeleaf("/pay");
    }
}
