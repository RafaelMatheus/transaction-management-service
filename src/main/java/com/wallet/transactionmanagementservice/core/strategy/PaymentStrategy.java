package com.wallet.transactionmanagementservice.core.strategy;

import com.wallet.transactionmanagementservice.core.enumerated.TransactionType;
import com.wallet.transactionmanagementservice.core.port.TransactionPort;

public class PaymentStrategy extends AbstractStrategy {
    public PaymentStrategy(TransactionPort port) {
        super(port);
    }

    @Override
    public TransactionType getType() {
        return TransactionType.PAYMENT;
    }
}
