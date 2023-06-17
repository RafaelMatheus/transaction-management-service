package com.wallet.accountmanagementservice.adapter.dtos.response;

import java.math.BigDecimal;

public record AccountResponse(
        String holderTaxId,
        String holderName,
        String phoneNumber,
        BigDecimal balance,
        String accountNumber
) {
}
