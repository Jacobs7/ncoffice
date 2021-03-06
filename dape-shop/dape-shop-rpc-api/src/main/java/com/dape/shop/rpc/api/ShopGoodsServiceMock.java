package com.dape.shop.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.shop.dao.mapper.ShopGoodsMapper;
import com.dape.shop.dao.model.ShopGoods;
import com.dape.shop.dao.model.ShopGoodsExample;

import java.util.Map;

/**
* 降级实现ShopGoodsService接口
* Created by dape on 2018/11/17.
*/
public class ShopGoodsServiceMock extends BaseServiceMock<ShopGoodsMapper, ShopGoods, ShopGoodsExample> implements ShopGoodsService {

    @Override
    public Map<String, Object> loadGoods(Long pageNum, Long pageSize, Map<String, Object> params) {
        return null;
    }

    @Override
    public Map<String, Object> loadCouponGoodsBySeach(Long pageNum, Long pageSize, Map<String, Object> params) { return null; }

    @Override
    public Map<String, Object> loadCouponGoods(Long pageNum, Long pageSize, Map<String, Object> params) { return null; }

    @Override
    public Map<String, Object> findGoods(Long numIids, Map<String, Object> params) {
        return null;
    }

    @Override
    public Map<String, Object> getTKL(Map<String, Object> params) { return null; }

    @Override
    public Map<String, Object> tbkItemInfoGet(String itemId, Long platform, String ip) {
        return null;
    }

    @Override
    public Map<String, Object> tbkJuTqgGet(Long pageNum, Long pageSize) {
        return null;
    }

    @Override
    public Integer updateGoodsByCouponEndTime() {
        return 0;
    }

    @Override
    public Map<String, Object> tbkDgItemCouponGet(Long pageNum, Long pageSize, Map<String, Object> params) {
        return null;
    }
}
