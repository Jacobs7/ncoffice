package com.dape.shop.web.controller;

import com.dape.common.base.BaseController;
import com.dape.common.util.NewImageUtil;
import com.dape.shop.dao.model.*;
import com.dape.shop.rpc.api.ShopGoodsService;
import com.dape.shop.rpc.api.ShopMenuService;
import com.dape.shop.rpc.api.ShopModuleService;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * 首页控制器
 * ncoffice on 2018/11/20.
 */
@Controller
@RequestMapping("module")
public class ModuleController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ModuleController.class);

    /**
     * 赚钱教程
     * @param model
     * @return
     */
    @RequestMapping(value = "/courseZhuan", method = RequestMethod.GET)
    public String edit(Model model) {
       return thymeleaf("/course-zhuan");
    }

    /**
     * 省钱教程页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/courseSheng", method = RequestMethod.GET)
    public String order(Model model) {
        return thymeleaf("/course-sheng");
    }

    /**
     * 常见问题
     * @param model
     * @return
     */
    @RequestMapping(value = "/question", method = RequestMethod.GET)
    public String question(Model model) {
        return thymeleaf("/question");
    }
}
