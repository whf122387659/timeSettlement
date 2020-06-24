package com.dbb.service.impl;

import com.dbb.dao.MerchantMapper;
import com.dbb.entity.Merchant;
import com.dbb.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantServiceImpl implements MerchantService {
    @Autowired
    private MerchantMapper merchantMapper;

    @Override
    public List<Merchant> selectAllMerchant(String companyId) {
        return merchantMapper.selectAllMerchant(companyId);
    }

    @Override
    public Merchant selectMerchantById(String id) {
        return merchantMapper.selectMerchantById(id);
    }

    @Override
    public List<Merchant> selectOppenMerchant(String companyId) {
        return merchantMapper.selectOppenMerchant(companyId);
    }

    @Override
    public void updateBalance(Merchant merchant) {
            merchantMapper.updateBalance(merchant);
    }


}
