package com.wallet.transactionmanagementservice.core.base;

import com.wallet.transactionmanagementservice.adapter.entity.TransactionEntity;
import com.wallet.transactionmanagementservice.core.domain.TransactionDomain;
import com.wallet.transactionmanagementservice.core.enumerated.TransactionType;

import java.math.BigDecimal;
import java.util.UUID;

public class BaseTest {
    private static final TransactionType TYPE = TransactionType.DEPOSIT;
    private static final BigDecimal AMOUNT = BigDecimal.ZERO;
    private static final String ORIGIN_ACCOUNT = "xpto1";
    private static final String DESTINATION_ACCOUNT = "xpto52";
    private static final String ID = UUID.randomUUID().toString();

    private BaseTest() {
    }

    public static TransactionEntity getEntity() {
        return new TransactionEntity(ID, DESTINATION_ACCOUNT, ORIGIN_ACCOUNT, AMOUNT, TYPE, null);
    }

    public static TransactionDomain getDomain() {
        return new TransactionDomain(DESTINATION_ACCOUNT, ORIGIN_ACCOUNT, AMOUNT, TYPE);
    }
}
