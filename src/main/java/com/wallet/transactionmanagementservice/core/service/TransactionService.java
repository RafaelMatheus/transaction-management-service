package com.wallet.transactionmanagementservice.core.service;

import com.wallet.transactionmanagementservice.core.domain.TransactionDomain;

public interface TransactionService {
    TransactionDomain executeAccountTransaction(TransactionDomain toTransactionDomain);
}
