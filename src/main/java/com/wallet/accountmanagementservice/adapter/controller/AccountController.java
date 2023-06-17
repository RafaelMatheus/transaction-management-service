package com.wallet.accountmanagementservice.adapter.controller;

import com.wallet.accountmanagementservice.adapter.dtos.request.AccountDepositRequest;
import com.wallet.accountmanagementservice.adapter.dtos.request.AccountRequest;
import com.wallet.accountmanagementservice.adapter.dtos.response.AccountResponse;
import com.wallet.accountmanagementservice.core.helper.Mapper;
import com.wallet.accountmanagementservice.core.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public AccountResponse generateAccount(@RequestBody AccountRequest request) {
        return Mapper.toResponse(accountService.generateAccount(Mapper.toDomain(request)));
    }

    @GetMapping("/{accountNumber}")
    public AccountResponse getAccountInformationByAccountNumber(String accountNumber) {
        return Mapper.toResponse(accountService.getAccountInformation(accountNumber));
    }

    @PostMapping("/deposits")
    public void deposit(@RequestBody AccountDepositRequest depositRequest) {
        accountService.deposit( depositRequest.destinationAccountNumber(), depositRequest.value());
    }

    @PostMapping("/{accountNumber}/withdrawals")
    public void withdrawals(AccountDepositRequest depositRequest) {
        accountService.deposit(depositRequest.destinationAccountNumber(), depositRequest.value());
    }

    @PostMapping("/{accountNumber}/transfers")
    public void transfers(AccountDepositRequest depositRequest) {
        accountService.deposit(depositRequest.destinationAccountNumber(), depositRequest.value());
    }
}
