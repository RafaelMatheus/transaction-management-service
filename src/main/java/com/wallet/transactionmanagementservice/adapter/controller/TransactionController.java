package com.wallet.transactionmanagementservice.adapter.controller;

import com.wallet.transactionmanagementservice.adapter.dtos.request.TransactionRequest;
import com.wallet.transactionmanagementservice.core.helper.Mapper;
import com.wallet.transactionmanagementservice.core.service.TransactionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/accounts")
public class TransactionController {
    private final TransactionService accountService;

    public TransactionController(TransactionService accountService) {
        this.accountService = accountService;
    }


//    @PostMapping("/transaction")
//    public void executeAccountTransaction(@RequestBody TransactionRequest transactionRequest) {
//        accountService.executeAccountTransaction(Mapper.toTransactionDomain(transactionRequest));
//    }
}
