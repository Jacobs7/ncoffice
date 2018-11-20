package com.dape.shop.web.controller;

import com.dape.common.base.BaseController;
import com.dape.common.util.PropertiesFileUtil;
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

    @RequestMapping(value = "/loadGoods", method = RequestMethod.POST)
    @ResponseBody
    public List<ShopGoods> loadGoods(HttpServletRequest req) {
        String pageNum = req.getParameter("pageNum");
        String pageSize = req.getParameter("pageSize");
        System.out.println("pageNum: " + pageNum + " ,pageSize: " + pageSize);

        List<ShopGoods> goods = new ArrayList<ShopGoods>();
        String appName = PropertiesFileUtil.getInstance().get("app.name");
        String uiPath = PropertiesFileUtil.getInstance().get("dape.ui.path");
        ShopGoods item = null;
        for(int i = 1;i <= 10; i++){
            item = new ShopGoods();
            item.setId(1L + i);
            item.setPictUrl(uiPath + appName + "/upload/pro"+ (i%5+1)+".jpg");
            item.setTitle("洋河蓝色瓶装经典Q7浓香型白酒500ml52度高端纯粮食白酒2瓶装包邮");
            item.setReservePrice("99.84");

            goods.add(item);
        }

        return goods;
    }
}
