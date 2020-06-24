package com.dbb.service;

import com.dbb.entity.Price;

import java.util.List;

public interface PriceService {
    /**
     * 根据商户id查询计费信息
     * @param merchantid
     * @return
     */
    Price selectPriceByMerchantId(Integer merchantid);
}
