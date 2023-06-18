package com.wallet.transactionmanagementservice.core.service.impl;

import com.wallet.transactionmanagementservice.core.domain.TransactionDomain;
import com.wallet.transactionmanagementservice.core.domain.TransactionHistoryPageResponse;
import com.wallet.transactionmanagementservice.core.port.impl.TransactionPortRepository;
import com.wallet.transactionmanagementservice.core.service.TransactionService;
import com.wallet.transactionmanagementservice.core.strategy.TransactionFactory;

public class TransactionServiceImpl implements TransactionService {
    private final TransactionFactory factory;
    private final TransactionPortRepository repository;

    public TransactionServiceImpl(TransactionFactory factory, TransactionPortRepository repository) {
        this.factory = factory;
        this.repository = repository;
    }

    @Override
    public TransactionDomain executeAccountTransaction(TransactionDomain toTransactionDomain) {
        return factory.get(toTransactionDomain.type()).process(toTransactionDomain);
    }

    @Override
    public TransactionHistoryPageResponse<TransactionDomain> findByAccountNumber(String accountNumber, int size, int pageNumber) {
        return repository.findByAccountNumber(accountNumber, size, pageNumber);
    }
}
