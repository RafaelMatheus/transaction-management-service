package com.wallet.accountmanagementservice.adapter.controller;

import com.wallet.accountmanagementservice.adapter.dtos.request.AccountRequest;
import com.wallet.accountmanagementservice.adapter.dtos.response.AccountResponse;
import com.wallet.accountmanagementservice.core.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public AccountResponse generateAccount(@RequestBody AccountRequest request){
        //todo criar conta
        //todo obter informações da conta
        //todo fechar conta
        return null;
    }
}
