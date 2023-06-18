package com.wallet.transactionmanagementservice.core.strategy;

import com.wallet.transactionmanagementservice.core.enumerated.TransactionType;
import com.wallet.transactionmanagementservice.core.port.TransactionPort;

public class DepositStrategy extends AbstractStrategy {
    public DepositStrategy(TransactionPort port) {
        super(port);
    }

    @Override
    public TransactionType getType() {
        return TransactionType.DEPOSIT;
    }
}
