package com.wallet.transactionmanagementservice.adapter.dto;

import com.wallet.transactionmanagementservice.core.enumerated.TransactionType;

import java.math.BigDecimal;

public class TransactionResponse {
    private String destinationAccountNumber;
    private String originAccountNumber;
    private BigDecimal amount;
    private TransactionType type;

    public TransactionResponse() {
    }

    public TransactionResponse(String destinationAccountNumber, String originAccountNumber, BigDecimal amount, TransactionType type) {
        this.destinationAccountNumber = destinationAccountNumber;
        this.originAccountNumber = originAccountNumber;
        this.amount = amount;
        this.type = type;
    }

    public String getDestinationAccountNumber() {
        return destinationAccountNumber;
    }

    public void setDestinationAccountNumber(String destinationAccountNumber) {
        this.destinationAccountNumber = destinationAccountNumber;
    }

    public String getOriginAccountNumber() {
        return originAccountNumber;
    }

    public void setOriginAccountNumber(String originAccountNumber) {
        this.originAccountNumber = originAccountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }
}
