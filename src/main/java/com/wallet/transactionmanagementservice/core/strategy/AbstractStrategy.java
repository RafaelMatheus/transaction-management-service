package com.wallet.transactionmanagementservice.core.strategy;

import com.wallet.transactionmanagementservice.core.domain.TransactionDomain;
import com.wallet.transactionmanagementservice.core.port.TransactionPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractStrategy implements ProcessTransactionStrategy {
    private final Logger log = LoggerFactory.getLogger(AbstractStrategy.class);
    protected final TransactionPort port;

    protected AbstractStrategy(TransactionPort port) {
        this.port = port;
    }

    @Override
    public TransactionDomain process(TransactionDomain transactionDomain) {
        log.info("class=AbstractStrategy, m=process, transactionType={}", transactionDomain.type());
        return port.save(transactionDomain);
    }
}
