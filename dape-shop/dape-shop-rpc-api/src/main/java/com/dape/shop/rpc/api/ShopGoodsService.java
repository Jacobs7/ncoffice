package com.dape.shop.rpc.api;

import com.dape.common.base.BaseService;
import com.dape.shop.dao.model.ShopGoods;
import com.dape.shop.dao.model.ShopGoodsExample;

import java.util.List;

/**
* ShopGoodsService接口
* Created by dape on 2018/11/17.
*/
public interface ShopGoodsService extends BaseService<ShopGoods, ShopGoodsExample> {

    public List<ShopGoods> loadGoods(int pageNum, int pageSize, ShopGoods shopGoods);

    public ShopGoods findGoods(String numIids, int platform, String ip);
}