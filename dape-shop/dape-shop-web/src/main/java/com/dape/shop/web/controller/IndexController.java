package com.dape.shop.web.controller;

import com.dape.common.base.BaseController;
import com.dape.shop.dao.model.*;
import com.dape.shop.rpc.api.ShopGoodsService;
import com.dape.shop.rpc.api.ShopMenuService;
import com.dape.shop.rpc.api.ShopModuleService;
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
    @Autowired
    private ShopMenuService shopMenuService;
    @Autowired
    private ShopModuleService shopModuleService;

    @RequestMapping(value = "demo", method = RequestMethod.GET)
    public String demo(Model model) {
        ShopGoodsExample example = new ShopGoodsExample();
        List<ShopGoods> list = shopGoodsService.selectByExample(example);
        model.addAttribute("list", list);
        return thymeleaf("/demo");
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, Long showId) {
        ShopGoodsExample example = new ShopGoodsExample();
        List<ShopGoods> list = shopGoodsService.selectByExample(example);
        model.addAttribute("list", list);

        // 查询导航栏列表: 首页、男装、女装等
        ShopMenuExample shopMenuE = new ShopMenuExample();
        shopMenuE.or().andIsEnabledEqualTo(true);
        shopMenuE.setOrderByClause("sort ASC");
        List<ShopMenu> menus = shopMenuService.selectByExample(shopMenuE);
        model.addAttribute("menus", menus);
        model.addAttribute("showId", showId == null ? 1L : showId);

        // 查询模块列表: 淘抢购、聚划算、拼多多、京东等
        ShopModuleExample shopModuleE = new ShopModuleExample();
        shopModuleE.or().andIsEnabledEqualTo(true);
        shopModuleE.setOrderByClause("sort ASC");
        List<ShopModule> modules = shopModuleService.selectByExample(shopModuleE);
        model.addAttribute("modules", modules);

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
