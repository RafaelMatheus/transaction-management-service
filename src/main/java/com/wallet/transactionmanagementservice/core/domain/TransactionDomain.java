package com.wallet.transactionmanagementservice.core.domain;

import com.wallet.transactionmanagementservice.core.enumerated.TransactionType;

import java.math.BigDecimal;

public record TransactionDomain(
        String destinationAccountNumber,
        String originAccountNumber,
        BigDecimal value,
        TransactionType type
) {
}
