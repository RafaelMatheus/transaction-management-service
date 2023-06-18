package com.wallet.transactionmanagementservice.core.port.impl;

import com.wallet.transactionmanagementservice.adapter.repository.TransactionRepository;
import com.wallet.transactionmanagementservice.core.domain.TransactionDomain;
import com.wallet.transactionmanagementservice.core.helper.Mapper;
import com.wallet.transactionmanagementservice.core.port.TransactionPort;

public class TransactionPortRepository implements TransactionPort {
    private final TransactionRepository transactionRepository;

    public TransactionPortRepository(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public TransactionDomain save(TransactionDomain accountDomain) {
        var saved = transactionRepository.save(Mapper.toEntity(accountDomain));
        return Mapper.toDomain(saved);
    }

    @Override
    public TransactionDomain findByAccountNumber(String accountNumber) {
        return null;
    }

}
