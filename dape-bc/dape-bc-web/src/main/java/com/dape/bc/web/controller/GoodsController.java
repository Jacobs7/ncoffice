package com.dape.bc.web.controller;

import com.dape.bc.rpc.api.BcGoodsService;
import com.dape.bc.rpc.api.BcModuleService;
import com.dape.common.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页控制器
 * ncoffice on 2018/11/20.
 */
@Controller
@RequestMapping("goods")
public class GoodsController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    private BcGoodsService bcGoodsService;
    @Autowired
    public BcModuleService bcModuleService;

}
