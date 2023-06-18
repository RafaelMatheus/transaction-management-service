package com.wallet.transactionmanagementservice.core.strategy;

import com.wallet.transactionmanagementservice.core.enumerated.TransactionType;
import com.wallet.transactionmanagementservice.core.port.TransactionPort;

public class TransferStrategy extends AbstractStrategy {
    public TransferStrategy(TransactionPort port) {
        super(port);
    }

    @Override
    public TransactionType getType() {
        return TransactionType.TRANSFER;
    }
}
