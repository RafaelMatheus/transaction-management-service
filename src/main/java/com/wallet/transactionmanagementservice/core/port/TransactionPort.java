package com.wallet.transactionmanagementservice.core.port;

import com.wallet.transactionmanagementservice.core.domain.TransactionDomain;

public interface TransactionPort {
    TransactionDomain save(TransactionDomain accountDomain);
    TransactionDomain findByAccountNumber(String accountNumber);
}
