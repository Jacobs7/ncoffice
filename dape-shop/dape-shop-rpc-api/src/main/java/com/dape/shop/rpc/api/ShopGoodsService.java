package com.dape.shop.rpc.api;

import com.dape.common.base.BaseService;
import com.dape.shop.dao.model.ShopGoods;
import com.dape.shop.dao.model.ShopGoodsExample;

import java.util.Map;

/**
* ShopGoodsService接口
* Created by dape on 2018/11/17.
*/
public interface ShopGoodsService extends BaseService<ShopGoods, ShopGoodsExample> {

    /**
     * 淘宝客商品查询(只有商品列表，没有券信息)
     * @param pageNum
     * @param pageSize
     * @param params
     * @return
     */
    public Map<String, Object> loadGoods(Long pageNum, Long pageSize, Map<String, Object> params);

    /**
     * 好券清单API【导购】
     * @param pageNum
     * @param pageSize
     * @param params
     * @return
     */
    public Map<String, Object> loadCouponGoods(Long pageNum, Long pageSize, Map<String, Object> params);

    public Map<String, Object> findGoods(String numIids, int platform, String ip);
}