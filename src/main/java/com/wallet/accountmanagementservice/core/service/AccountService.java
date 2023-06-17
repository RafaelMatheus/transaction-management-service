package com.wallet.accountmanagementservice.core.service;

import com.wallet.accountmanagementservice.core.domain.AccountDomain;

import java.math.BigDecimal;

public interface AccountService {
    AccountDomain generateAccount(AccountDomain accountDomain);

    AccountDomain getAccountInformation(String accountNumber);

    AccountDomain withdrawFunds(String accountNumberOrigin, String accountNumberDestiny);

    void deposit(String destinationAccountNumber, BigDecimal value);
}
