package com.dbb.dao;

import com.dbb.entity.Price;

import java.util.List;

public interface PriceMapper {
    /**
     * 根据商户id查询计费信息
     * @param merchantid
     * @return
     */
    Price selectPriceByMerchantId(Integer merchantid);
}
