package com.wallet.transactionmanagementservice.core.strategy;

import com.wallet.transactionmanagementservice.core.enumerated.TransactionType;
import com.wallet.transactionmanagementservice.core.port.TransactionPort;

public class WithdrawStrategy extends AbstractStrategy {

    public WithdrawStrategy(TransactionPort port) {
        super(port);
    }

    @Override
    public TransactionType getType() {
        return TransactionType.WITHDRAW;
    }

}
