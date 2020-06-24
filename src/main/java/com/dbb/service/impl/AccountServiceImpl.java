package com.dbb.service.impl;

import com.dbb.dao.AccountMapper;
import com.dbb.entity.Account;
import com.dbb.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> selectAllAccount() {
        return accountMapper.selectAllAccount();
    }

    @Override
    public void updateAccount(Account account) {
        accountMapper.updateAccount(account);
    }

    @Override
    public int selectCount(String collectors) {
        return accountMapper.selectCount(collectors);
    }
}
