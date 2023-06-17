package com.wallet.accountmanagementservice.adapter.dtos.request;

public record AccountRequest(
        String holderTaxId,
        String holderName,
        String phoneNumber
) {
}
