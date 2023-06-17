package com.wallet.accountmanagementservice.adapter.config;

import com.wallet.accountmanagementservice.adapter.repository.AccountRepository;
import com.wallet.accountmanagementservice.core.service.AccountService;
import com.wallet.accountmanagementservice.core.service.impl.AccountServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceBeanConfig {
    @Bean
    public AccountService accountService(AccountRepository repository){
        return new AccountServiceImpl(repository);
    }
}
