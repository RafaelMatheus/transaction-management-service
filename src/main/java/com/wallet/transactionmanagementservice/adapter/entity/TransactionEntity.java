package com.wallet.transactionmanagementservice.adapter.entity;

import com.wallet.transactionmanagementservice.core.enumerated.TransactionType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document("transaction")
public class TransactionEntity {
    @Id
    private String id;
    private String destinationAccountNumber;
    private String originAccountNumber;
    private BigDecimal amount;
    private TransactionType type;
    private LocalDateTime creationDateTime;

    public TransactionEntity() {
    }

    public TransactionEntity(String id, String destinationAccountNumber, String originAccountNumber, BigDecimal value, TransactionType type, LocalDateTime creationDateTime) {
        this.id = id;
        this.destinationAccountNumber = destinationAccountNumber;
        this.originAccountNumber = originAccountNumber;
        this.amount = value;
        this.type = type;
        this.creationDateTime = creationDateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
