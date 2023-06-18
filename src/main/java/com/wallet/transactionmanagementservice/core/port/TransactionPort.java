package com.wallet.transactionmanagementservice.core.port;

import com.wallet.transactionmanagementservice.core.domain.TransactionDomain;
import com.wallet.transactionmanagementservice.core.domain.TransactionHistoryPageResponse;

public interface TransactionPort {
    TransactionDomain save(TransactionDomain accountDomain);
    TransactionHistoryPageResponse<TransactionDomain> findByAccountNumber(String accountNumber, int size, int pageNumber);
}
