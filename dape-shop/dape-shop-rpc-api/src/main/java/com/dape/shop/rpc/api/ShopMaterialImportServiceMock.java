package com.dape.shop.rpc.api;

import com.alibaba.fastjson.JSONArray;
import com.dape.common.base.BaseServiceMock;
import com.dape.shop.dao.mapper.ShopMaterialImportMapper;
import com.dape.shop.dao.model.ShopMaterialImport;
import com.dape.shop.dao.model.ShopMaterialImportExample;

import java.math.BigDecimal;

/**
* 降级实现ShopMaterialImportService接口
* Created by dape on 2019/3/5.
*/
public class ShopMaterialImportServiceMock extends BaseServiceMock<ShopMaterialImportMapper, ShopMaterialImport, ShopMaterialImportExample> implements ShopMaterialImportService {

    @Override
    public Integer[] importGoodsByMaterial(ShopMaterialImport shopMaterialImport, JSONArray mapData, BigDecimal tbkCouponAmount, BigDecimal tbkCouponRate, Integer importRate) {
        return null;
    }
}
