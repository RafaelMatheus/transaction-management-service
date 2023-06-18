package com.wallet.transactionmanagementservice.core.helper;

import com.wallet.transactionmanagementservice.adapter.entity.TransactionEntity;
import com.wallet.transactionmanagementservice.core.domain.TransactionDomain;
import com.wallet.transactionmanagementservice.core.domain.TransactionRabbitMqDomain;

import java.time.LocalDateTime;

public class Mapper {
    private Mapper() {
    }

    public static TransactionEntity toEntity(TransactionDomain domain) {
        return new TransactionEntity(null, domain.destinationAccountNumber(),
                domain.originAccountNumber(),
                domain.value(), domain.type(),
                LocalDateTime.now());
    }

    public static TransactionDomain toDomain(TransactionEntity transactionEntity) {
        return new TransactionDomain(transactionEntity.getDestinationAccountNumber(),
                transactionEntity.getOriginAccountNumber(),
                transactionEntity.getAmount(), transactionEntity.getType());
    }

    public static TransactionDomain toDomain(TransactionRabbitMqDomain transactionEntity) {
        return new TransactionDomain(transactionEntity.getDestinationAccount(),
                transactionEntity.getOriginAccount(),
                transactionEntity.getValue(), transactionEntity.getTransactionType());
    }
}
