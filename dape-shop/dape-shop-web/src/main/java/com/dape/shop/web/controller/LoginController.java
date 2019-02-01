package com.dape.shop.web.controller;

import com.dape.common.base.BaseController;
import com.dape.common.util.QRCodeUtil;
import com.dape.shop.common.constant.ShopTypeEnum;
import com.dape.shop.dao.model.ShopGoods;
import com.dape.shop.dao.model.ShopStore;
import com.dape.shop.dao.model.ShopUser;
import com.dape.shop.rpc.api.ShopGoodsService;
import com.dape.shop.rpc.api.ShopStoreService;
import com.google.zxing.BarcodeFormat;
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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页控制器
 * ncoffice on 2018/11/20.
 */
@Controller
@RequestMapping("login")
public class LoginController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    /**
     * 商品详情
     * @param numIid id
     * @param platform 1:pc端,2:无线端
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
        return thymeleaf("/login");
    }
}
