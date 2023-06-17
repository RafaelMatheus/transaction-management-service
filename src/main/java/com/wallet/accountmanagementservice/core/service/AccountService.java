package com.wallet.accountmanagementservice.core.service;

import com.wallet.accountmanagementservice.core.domain.AccountDomain;
import com.wallet.accountmanagementservice.core.domain.TransactionDomain;

public interface AccountService {
    AccountDomain generateAccount(AccountDomain accountDomain);

    AccountDomain getAccountInformation(String accountNumber);

    AccountDomain executeAccountTransaction(TransactionDomain toTransactionDomain);
}
