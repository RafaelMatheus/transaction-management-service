package com.wallet.accountmanagementservice.core.helper;

import com.wallet.accountmanagementservice.adapter.dtos.request.AccountRequest;
import com.wallet.accountmanagementservice.adapter.dtos.response.AccountResponse;
import com.wallet.accountmanagementservice.adapter.entity.AccountEntity;
import com.wallet.accountmanagementservice.core.domain.AccountDomain;
import com.wallet.accountmanagementservice.core.domain.TransactionRabbitMqDomain;
import com.wallet.accountmanagementservice.core.enumerated.TransactionType;

import java.math.BigDecimal;

public class Mapper {
    private Mapper() {
    }

    public static AccountEntity toEntity(AccountDomain domain) {
        var accountEntity = new AccountEntity();

        accountEntity.setHolderName(domain.getHolderName());
        accountEntity.setAccountNumber(domain.getAccountNumber());
        accountEntity.setHolderTaxId(domain.getHolderTaxId());
        accountEntity.setBalance(domain.getBalance());
        return accountEntity;
    }

    public static AccountDomain toDomain(AccountEntity entity) {
        var accountDomain = new AccountDomain();

        accountDomain.setHolderName(entity.getHolderName());
        accountDomain.setHolderTaxId(entity.getHolderTaxId());
        accountDomain.setBalance(entity.getBalance());
        return accountDomain;
    }

    public static AccountDomain toDomain(AccountRequest request) {
        var accountDomain = new AccountDomain();

        accountDomain.setHolderName(request.holderName());
        accountDomain.setHolderTaxId(request.holderTaxId());
        return accountDomain;
    }

    public static AccountResponse toResponse(AccountDomain accountDomain) {
        return new AccountResponse(accountDomain.getHolderTaxId(), accountDomain.getHolderName(),
                accountDomain.getPhoneNumber(), accountDomain.getBalance(),
                accountDomain.getAccountNumber());
    }

    public static TransactionRabbitMqDomain toTransactionRabbitDomainDeposit(AccountDomain destinationAccount, BigDecimal value) {
        return new TransactionRabbitMqDomain(TransactionType.DEPOSIT, null, destinationAccount.getAccountNumber(), value);
    }

}