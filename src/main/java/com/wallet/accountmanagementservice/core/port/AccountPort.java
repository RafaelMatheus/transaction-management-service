package com.wallet.accountmanagementservice.core.port;

import com.wallet.accountmanagementservice.core.domain.AccountDomain;

import javax.security.auth.login.AccountNotFoundException;

public interface AccountPort {
    AccountDomain save(AccountDomain accountDomain);
    AccountDomain findByAccountNumber(String accountNumber);
}
