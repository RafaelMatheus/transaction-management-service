package com.wallet.transactionmanagementservice.adapter.repository;

import com.wallet.transactionmanagementservice.adapter.entity.TransactionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionRepository extends MongoRepository<TransactionEntity, String> {
    Optional<TransactionEntity> findByOriginAccountNumber(String accountNumber);
}
