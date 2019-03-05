package com.dape.shop.rpc.api;

import com.alibaba.fastjson.JSONArray;
import com.dape.common.base.BaseService;
import com.dape.shop.dao.model.ShopMaterialImport;
import com.dape.shop.dao.model.ShopMaterialImportExample;

import java.math.BigDecimal;

/**
* ShopMaterialImportService接口
* Created by dape on 2019/3/5.
*/
public interface ShopMaterialImportService extends BaseService<ShopMaterialImport, ShopMaterialImportExample> {

    /**
     * 分类从淘宝客导入商品，物料分类
     * @param shopMaterialImport
     * @return
     */
    public Integer[] importGoodsByMaterial(ShopMaterialImport shopMaterialImport, JSONArray mapData, BigDecimal tbkCouponAmount, BigDecimal tbkCouponRate);
}