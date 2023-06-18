package com.wallet.transactionmanagementservice.core.service;

import com.wallet.transactionmanagementservice.core.domain.TransactionDomain;
import com.wallet.transactionmanagementservice.core.domain.TransactionHistoryPageResponse;

public interface TransactionService {

    TransactionDomain executeAccountTransaction(TransactionDomain toTransactionDomain);

    TransactionHistoryPageResponse<TransactionDomain> findByAccountNumber(String accountNumber, int size, int pageNumber);
}
