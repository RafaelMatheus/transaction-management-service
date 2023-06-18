package com.wallet.transactionmanagementservice.core.helper;

import com.wallet.transactionmanagementservice.adapter.dto.TransactionResponse;
import com.wallet.transactionmanagementservice.adapter.entity.TransactionEntity;
import com.wallet.transactionmanagementservice.core.domain.TransactionDomain;
import com.wallet.transactionmanagementservice.core.domain.TransactionHistoryPageResponse;
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

    public static TransactionResponse toResponse(TransactionDomain transactionDomain) {
        return new TransactionResponse(transactionDomain.destinationAccountNumber(),
                transactionDomain.originAccountNumber(),
                transactionDomain.value(), transactionDomain.type());
    }

    public static TransactionHistoryPageResponse<TransactionResponse> toTransactionHistory(TransactionHistoryPageResponse<TransactionDomain> byAccountNumber) {
        var response = byAccountNumber.getContent().stream().map(Mapper::toResponse).toList();
        return TransactionHistoryPageResponse.of(response, byAccountNumber.getSize(), byAccountNumber.getPageNumber(), byAccountNumber.getTotalPages());
    }
}
