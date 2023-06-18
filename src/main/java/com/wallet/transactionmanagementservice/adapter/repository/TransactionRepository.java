package com.wallet.transactionmanagementservice.adapter.repository;

import com.wallet.transactionmanagementservice.adapter.entity.TransactionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<TransactionEntity, String> {
    Page<TransactionEntity> findByOriginAccountNumberOrDestinationAccountNumber(String accountNumber,String destinationAccountNumber, Pageable pageable);
}
