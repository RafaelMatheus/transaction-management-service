package com.wallet.accountmanagementservice.core.repository;

import com.wallet.accountmanagementservice.adapter.repository.AccountRepository;
import com.wallet.accountmanagementservice.core.port.AccountPort;

public class AccountPortRepository implements AccountPort {
    private final AccountRepository accountRepository;

    public AccountPortRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}
