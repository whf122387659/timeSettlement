package com.dbb.service.impl;

import com.dbb.dao.PriceMapper;
import com.dbb.entity.Price;
import com.dbb.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    private PriceMapper priceMapper;
    @Override
    public Price selectPriceByMerchantId(Integer merchantid) {
        return priceMapper.selectPriceByMerchantId(merchantid);
    }
}
