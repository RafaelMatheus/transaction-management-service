package com.wallet.transactionmanagementservice.adapter.dtos.request;

import com.wallet.transactionmanagementservice.core.enumerated.TransactionType;

import java.math.BigDecimal;

public record TransactionRequest(
        String destinationAccountNumber,
        String originAccountNumber,
        BigDecimal value,
        TransactionType type
) {
}
