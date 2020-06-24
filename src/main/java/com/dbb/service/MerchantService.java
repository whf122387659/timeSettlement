package com.dbb.service;

import com.dbb.entity.Merchant;

import java.util.List;

public interface MerchantService {

    /**
     * 查询所有预付费账户信息
     * @return
     */
    public List<Merchant> selectAllMerchant(String companyId);
    /**
     * 查询预付费账户详情信息
     * @return
     */
    public Merchant selectMerchantById(String id);

    /**
     * 查询已开户的账户
     * @return
     */
    public List<Merchant> selectOppenMerchant(String companyId);

    /**
     * 修改账户余额
     * @return
     */
    public void updateBalance(Merchant merchant);

}
