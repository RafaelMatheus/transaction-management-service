package com.wallet.accountmanagementservice.core.domain;

import java.math.BigDecimal;

public class AccountDomain {
    private String id;
    private String holderTaxId;
    private String holderName;
    private String phoneNumber;
    private BigDecimal balance;
    private String accountNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHolderTaxId() {
        return holderTaxId;
    }

    public void setHolderTaxId(String holderTaxId) {
        this.holderTaxId = holderTaxId;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
