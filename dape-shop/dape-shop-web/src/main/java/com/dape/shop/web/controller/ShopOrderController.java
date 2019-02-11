package com.dape.shop.web.controller;

import com.dape.shop.dao.model.ShopOrder;
import com.dape.shop.dao.model.ShopOrderExample;
import com.dape.shop.dao.model.ShopUser;
import com.dape.shop.dao.model.ShopUserExample;
import com.dape.shop.rpc.api.ShopOrderService;
import com.dape.shop.rpc.api.ShopUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.dape.common.base.BaseController.thymeleaf;

/**
 * 首页控制器
 * ncoffice on 2018/11/20.
 */
@Controller
@RequestMapping("order")
public class ShopOrderController {

    @Autowired
    public ShopOrderService shopOrderService;
    @Autowired
    public ShopUserService shopUserService;

    /**
     * 转向最近订单页
     * @param tab
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/toOrders", method = RequestMethod.GET)
    public String toFrends(Integer tab, Model model, HttpServletRequest request) {
        if(tab == null){
            model.addAttribute("tab", 1);
        }else{
            model.addAttribute("tab", tab);
        }
        return thymeleaf("/orders");
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> orders(String orderId, Integer pageNum, Integer pageSize, Integer tab, Model model, HttpServletRequest request) {
        if(tab == null){ // 1:最近订单, 2:我的推广
            tab = 1;
        }

        Object o = request.getSession().getAttribute("shopuser");

        List<ShopOrder> orders = new ArrayList<ShopOrder>();

        int daifanMoney = 0;
        int yifanMoney = 0;

        if(o != null){
            ShopUser shopuser = (ShopUser)o;
            ShopOrderExample shopOrderE = new ShopOrderExample();

            if(tab == 1){ // 最近订单, 分页功能还没加
                ShopOrderExample.Criteria criteria = shopOrderE.createCriteria();
                criteria.andShopUserIdEqualTo(shopuser.getId());
                if(StringUtils.isNotBlank(orderId)){
                    criteria.andOrderIdLike("%" + orderId + "%");
                }
                shopOrderE.setOrderByClause("create_date desc");
                orders = shopOrderService.selectByExampleForStartPage(shopOrderE, pageNum, pageSize);
            }else if(tab == 2){// 我的推广,  分页功能还没加
                ShopOrder shopOrder = new ShopOrder();
                if(StringUtils.isNotBlank(orderId)) {
                    shopOrder.setOrderId(orderId);
                }
                orders = shopOrderService.selectTuiGuangOrder(pageNum, pageSize, shopuser, shopOrder);
            }

            ShopOrder shopOrder = new ShopOrder();
            shopOrder.setShopUserId(shopuser.getId());

            // 待返佣金
            shopOrder.setStatus(2); // 订单状态 1:已生成订单，2:已收货订单，3:已返佣订单
            daifanMoney = shopOrderService.getUserMoney(shopOrder);

            // 已返佣金
            shopOrder.setStatus(3); // 订单状态 1:已生成订单，2:已收货订单，3:已返佣订单
            yifanMoney = shopOrderService.getUserMoney(shopOrder);
        }
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("data", orders);
        result.put("daifanMoney", daifanMoney);
        result.put("yifanMoney", yifanMoney);
        return result;
    }
}
