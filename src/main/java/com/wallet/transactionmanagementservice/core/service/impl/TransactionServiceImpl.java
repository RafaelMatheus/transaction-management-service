package com.wallet.transactionmanagementservice.core.service.impl;

import com.wallet.transactionmanagementservice.core.domain.TransactionDomain;
import com.wallet.transactionmanagementservice.core.service.TransactionService;
import com.wallet.transactionmanagementservice.core.strategy.TransactionFactory;

public class TransactionServiceImpl implements TransactionService {
    private final TransactionFactory factory;

    public TransactionServiceImpl(TransactionFactory factory) {
        this.factory = factory;
    }

    @Override
    public TransactionDomain executeAccountTransaction(TransactionDomain toTransactionDomain) {
        return factory.get(toTransactionDomain.type()).process(toTransactionDomain);
    }
}
