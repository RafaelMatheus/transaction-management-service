package com.wallet.accountmanagementservice.adapter.dtos.request;

import java.math.BigDecimal;

public record AccountDepositRequest(
        String destinationAccountNumber,
        BigDecimal value
) {
}
