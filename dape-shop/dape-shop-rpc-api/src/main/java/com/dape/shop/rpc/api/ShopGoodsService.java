package com.dape.shop.rpc.api;

import com.dape.common.base.BaseService;
import com.dape.shop.dao.model.ShopGoods;
import com.dape.shop.dao.model.ShopGoodsExample;

import java.util.List;
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
     * 好券清单API【导购】：查询接口
     * @param pageNum
     * @param pageSize
     * @param params
     * @return
     */
    public Map<String, Object> loadCouponGoodsBySeach(Long pageNum, Long pageSize, Map<String, Object> params);

    /**
     * 好券清单API【导购】：根据物料ID加载接口
     * @param pageNum
     * @param pageSize
     * @param params
     * @return
     */
    public Map<String, Object> loadCouponGoods(Long pageNum, Long pageSize, Map<String, Object> params);

    /**
     * 查询商品详情
     * @param numIids
     * @param params
     * @return
     */
    public Map<String, Object> findGoods(Long numIids, Map<String, Object> params);

    /**
     * 查询商品详情
     * @param params
     * @return
     */
    public Map<String, Object> getTKL(Map<String, Object> params);

    /**
     * 淘宝客简版详情
     * @param itemId
     * @param platform
     * @param ip
     * @return
     */
    public Map<String, Object> tbkItemInfoGet(String itemId, Long platform, String ip);

    /**
     * 淘抢购
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> tbkJuTqgGet(Long pageNum, Long pageSize);
}