package com.dape.shop.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.shop.dao.mapper.ShopGoodsMapper;
import com.dape.shop.dao.model.ShopGoods;
import com.dape.shop.dao.model.ShopGoodsExample;

import java.util.List;

/**
* 降级实现ShopGoodsService接口
* Created by dape on 2018/11/17.
*/
public class ShopGoodsServiceMock extends BaseServiceMock<ShopGoodsMapper, ShopGoods, ShopGoodsExample> implements ShopGoodsService {

    @Override
    public List<ShopGoods> loadGoods(int pageNum, int pageSize, ShopGoods shopGoods) {
        return null;
    }

    @Override
    public ShopGoods findGoods(String numIids, int platform, String ip) {
        return null;
    }
}
