package com.wallet.accountmanagementservice.core.service.impl;

import com.wallet.accountmanagementservice.adapter.repository.AccountRepository;
import com.wallet.accountmanagementservice.core.domain.AccountDomain;
import com.wallet.accountmanagementservice.core.service.AccountService;

public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDomain generateAccount(AccountDomain accountDomain) {
        return null;
    }

    @Override
    public AccountDomain getAccountInformation(String accountNumber) {
        return null;
    }

    @Override
    public AccountDomain withdrawFunds(String accountNumberOrigin, String accountNumberDestiny) {
        return null;
    }
}
