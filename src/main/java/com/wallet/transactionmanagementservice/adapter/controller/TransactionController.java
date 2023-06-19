package com.wallet.transactionmanagementservice.adapter.controller;

import com.wallet.transactionmanagementservice.adapter.dto.TransactionResponse;
import com.wallet.transactionmanagementservice.core.domain.TransactionHistoryPageResponse;
import com.wallet.transactionmanagementservice.core.helper.Mapper;
import com.wallet.transactionmanagementservice.core.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public TransactionHistoryPageResponse<TransactionResponse> findByAccountNumber(String accountNumber, int size, int pageNumber) {
        return Mapper.toTransactionHistory(transactionService.findByAccountNumber(accountNumber, size, pageNumber));
    }
}
