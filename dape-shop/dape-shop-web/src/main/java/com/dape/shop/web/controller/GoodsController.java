package com.dape.shop.web.controller;

import com.dape.common.base.BaseController;
import com.dape.common.util.PropertiesFileUtil;
import com.dape.shop.dao.model.*;
import com.dape.shop.rpc.api.ShopGoodsService;
import com.dape.shop.rpc.api.ShopMenuService;
import com.dape.shop.rpc.api.ShopModuleService;
import com.dape.shop.rpc.api.ShopStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 首页控制器
 * ncoffice on 2018/11/20.
 */
@Controller
@RequestMapping("goods")
public class GoodsController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    private ShopGoodsService shopGoodsService;
    @Autowired
    private ShopStoreService shopStoreService;

    /**
     * 加载商品列表, ajax请求
     * @param pageNum 第几页
     * @param pageSize 每页多少条
     * @param query 查询条件
     * @return
     */
    @RequestMapping(value = "/loadGoods", method = RequestMethod.POST)
    @ResponseBody
    public List<ShopGoods> loadGoods(Integer pageNum, Integer pageSize, ShopGoods query) {
        return shopGoodsService.loadGoods(pageNum, pageSize, query);
    }

    /**
     * 商品详情
     * @param numIid id
     * @param platform 1:pc端,2:无线端
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/goodsDetail", method = RequestMethod.GET)
    public String goodsDetail(String numIid, int platform, Model model, HttpServletRequest request) {
        String ip = getIpAddress(request); // 真实ip地址
        ShopGoods shopGoods = shopGoodsService.findGoods(numIid,platform,ip);
        model.addAttribute("shopGoods", shopGoods);
        model.addAttribute("shopStore", shopStoreService.findShopStore(shopGoods.getSellerId().toString()));

        return thymeleaf("/goodsInfo");
    }

    /**
     * 转向查询页,get请求
     * @param pageNum 第几页
     * @param pageSize 每页多少条
     * @param sort 排序
     * @param query 查询条件
     * @param model
     * @return
     */
    @RequestMapping(value = "/toSearch", method = RequestMethod.POST)
    public String toSearch(Integer pageNum, Integer pageSize, Integer sort, ShopGoods query, Model model) {
        model.addAttribute("goodsList", shopGoodsService.loadGoods(pageNum, pageSize, query));
        model.addAttribute("query", query);
        model.addAttribute("sort", sort == null ? 1 : sort);
        return thymeleaf("/search");
    }

    /**
     * 获取真实ip地址
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
