package com.dape.bc.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.bc.dao.mapper.BcGoodsMapper;
import com.dape.bc.dao.model.BcGoods;
import com.dape.bc.dao.model.BcGoodsExample;

/**
* 降级实现BcGoodsService接口
* Created by dape on 2019/3/27.
*/
public class BcGoodsServiceMock extends BaseServiceMock<BcGoodsMapper, BcGoods, BcGoodsExample> implements BcGoodsService {

}
