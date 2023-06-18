package com.wallet.transactionmanagementservice.core.port.impl;

import com.wallet.transactionmanagementservice.adapter.repository.TransactionRepository;
import com.wallet.transactionmanagementservice.core.domain.TransactionDomain;
import com.wallet.transactionmanagementservice.core.domain.TransactionHistoryPageResponse;
import com.wallet.transactionmanagementservice.core.helper.Mapper;
import com.wallet.transactionmanagementservice.core.port.TransactionPort;
import org.springframework.data.domain.PageRequest;

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
    public TransactionHistoryPageResponse<TransactionDomain> findByAccountNumber(String accountNumber, int size, int pageNumber) {
        var response = transactionRepository.findByOriginAccountNumberOrDestinationAccountNumber(accountNumber, accountNumber, PageRequest.of(pageNumber, size))
                .map(Mapper::toDomain);

        return TransactionHistoryPageResponse.of(response.getContent(), response.getSize(),
                response.getNumber(), response.getTotalPages());
    }
}
