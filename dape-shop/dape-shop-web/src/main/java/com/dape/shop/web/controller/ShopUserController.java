package com.dape.shop.web.controller;

import com.dape.common.base.BaseController;
import com.dape.shop.dao.model.*;
import com.dape.shop.rpc.api.ShopUserInfoService;
import com.dape.shop.rpc.api.ShopUserService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页控制器
 * ncoffice on 2018/11/20.
 */
@Controller
@RequestMapping("user")
public class ShopUserController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShopUserController.class);

    @Autowired
    public ShopUserService shopUserService;
    @Autowired
    public ShopUserInfoService shopUserInfoService;

    @RequestMapping(value = "/mine", method = RequestMethod.GET)
    public String mine(Model model, HttpServletRequest request) {
        ShopUser user = new ShopUser();

        Object o = request.getSession().getAttribute("openId");
        if(o != null){
            ShopUserExample userExample = new ShopUserExample();
            userExample.or().andOpenIdEqualTo(o.toString());
            user = shopUserService.selectFirstByExample(userExample);
        }
        request.getSession().setAttribute("user", user); // 更新session
        model.addAttribute("user", user);

        return thymeleaf("/mine");
    }

    /**
     * 转向好友列表
     * @param frendTab
     * @param frendItem
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/toFrends", method = RequestMethod.GET)
    public String toFrends(Integer frendTab, Integer frendItem, Model model, HttpServletRequest request) {
        if(frendTab == null){
            model.addAttribute("frendTab", 1);
        }else{
            model.addAttribute("frendTab", frendTab);
        }
        if(frendItem == null){
            model.addAttribute("frendItem", 1);
        }else{
            model.addAttribute("frendItem", frendItem);
        }
        return thymeleaf("/frends");
    }

    /**
     * 查询好友列表数据
     * @param frendTab
     * @param frendItem
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/frends", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> frends(Integer pageNum, Integer pageSize, Integer frendTab, Integer frendItem, Model model, HttpServletRequest request) {
        if(frendTab == null){
            model.addAttribute("frendTab", 1);
        }else{
            model.addAttribute("frendTab", frendTab);
        }
        if(frendItem == null){
            model.addAttribute("frendItem", 1);
        }else{
            model.addAttribute("frendItem", frendItem);
        }

        Object o = request.getSession().getAttribute("user");

        List<ShopUserOrder> frends = new ArrayList<ShopUserOrder>();
        int count = 0;
        if(o != null){
            ShopUser user = (ShopUser)o;
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("sCode", user.getrCode());
            frends = shopUserService.listUserOrder(params);
            count = shopUserService.listUserOrderCount(params);
        }

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("totalCount", count);
        result.put("data", frends);
        return result;
    }

}
