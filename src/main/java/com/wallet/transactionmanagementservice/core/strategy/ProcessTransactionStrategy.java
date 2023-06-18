package com.wallet.transactionmanagementservice.core.strategy;

import com.wallet.transactionmanagementservice.core.domain.TransactionDomain;
import com.wallet.transactionmanagementservice.core.enumerated.TransactionType;

public interface ProcessTransactionStrategy {
    TransactionDomain process(TransactionDomain transactionDomain);

    TransactionType getType();
}
