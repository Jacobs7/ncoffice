package com.dape.shop.web.controller;

import com.dape.common.base.BaseController;
import com.dape.shop.dao.model.ShopGoods;
import com.dape.shop.dao.model.ShopGoodsExample;
import com.dape.shop.rpc.api.ShopGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 首页控制器
 * ncoffice on 2018/11/20.
 */
@Controller
public class IndexController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private ShopGoodsService shopGoodsService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String demo(Model model) {
        ShopGoodsExample example = new ShopGoodsExample();
        List<ShopGoods> list = shopGoodsService.selectByExample(example);
        model.addAttribute("list", list);
        return thymeleaf("/demo");
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        ShopGoodsExample example = new ShopGoodsExample();
        List<ShopGoods> list = shopGoodsService.selectByExample(example);
        model.addAttribute("list", list);
        return thymeleaf("/index");
    }

    @RequestMapping(value = "/proInfo", method = RequestMethod.GET)
    public String proInfo(Model model) {
        return thymeleaf("/pro_info");
    }

    @RequestMapping(value = "/mine", method = RequestMethod.GET)
    public String mine(Model model) {
        return thymeleaf("/mine");
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(Model model) {
        return thymeleaf("/address_edit");
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String order(Model model) {
        return thymeleaf("/all_orders");
    }
}
