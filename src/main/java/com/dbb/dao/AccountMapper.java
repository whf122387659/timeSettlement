package com.dbb.dao;

import com.dbb.entity.Account;

import java.util.List;

public interface AccountMapper {

    /**
     * 查询所有账户
     * @return
     */
    public List<Account> selectAllAccount();
    /**
     * 根据表记查询所有账户数量
     * @return
     */
    public int selectCount(String collectors);
    /**
     * 修改账户读数
     * @return
     */
    public void updateAccount(Account account);
}
