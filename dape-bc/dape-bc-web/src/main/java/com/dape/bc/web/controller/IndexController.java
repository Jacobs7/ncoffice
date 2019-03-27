package com.dape.bc.web.controller;

import com.dape.bc.dao.model.BcMenu;
import com.dape.bc.dao.model.BcMenuExample;
import com.dape.bc.dao.model.BcModule;
import com.dape.bc.dao.model.BcModuleExample;
import com.dape.bc.rpc.api.BcGoodsService;
import com.dape.bc.rpc.api.BcMenuService;
import com.dape.bc.rpc.api.BcModuleService;
import com.dape.common.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 首页控制器
 * ncoffice on 2018/11/20.
 */
@Controller
public class IndexController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private BcGoodsService bcGoodsService;
    @Autowired
    private BcMenuService bcMenuService;
    @Autowired
    private BcModuleService bcModuleService;

    public static List<BcMenu> menus = new ArrayList<BcMenu>();
    public static List<BcModule> modules = new ArrayList<BcModule>();

    /**
     * 首页
     * @param model
     * @param sId
     * @param type
     * @param request
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String localGoods(Model model, Long sId, Integer type, HttpServletRequest request) {

        /** 后面要放到缓存中 start */
        if(menus.size() <= 0){
            // 查询导航栏列表: 首页、男装、女装等
            BcMenuExample bcMenuE = new BcMenuExample();
            bcMenuE.or().andIsEnabledEqualTo(true);
            bcMenuE.setOrderByClause("sort ASC");
            menus = bcMenuService.selectByExample(bcMenuE);
        }
        int size = 7;
        if(menus.size() < size){
            size = menus.size();
        }
        model.addAttribute("menus", menus);
        model.addAttribute("menusSize", size);
        model.addAttribute("sId", sId == null ? 1L : sId);
        model.addAttribute("type", type == null ? 1 : type);

        // 查询模块列表: 淘抢购、聚划算、拼多多、京东等
        if(modules.size() <= 0){
            BcModuleExample bcModuleE = new BcModuleExample();
            bcModuleE.or().andIsEnabledEqualTo(true);
            bcModuleE.setOrderByClause("sort ASC");
            modules = bcModuleService.selectByExample(bcModuleE);
        }
        model.addAttribute("modules", modules);
        /** 后面要放到缓存中 end */

        return thymeleaf("/index");
    }

    /**
     * 常见问题
     * @param model
     * @return
     */
    @RequestMapping(value = "question", method = RequestMethod.GET)
    public String question(Model model) {
        return thymeleaf("/question");
    }
}
