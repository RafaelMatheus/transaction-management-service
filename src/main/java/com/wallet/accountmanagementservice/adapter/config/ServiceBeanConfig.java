package com.wallet.accountmanagementservice.adapter.config;

import com.wallet.accountmanagementservice.adapter.repository.AccountRepository;
import com.wallet.accountmanagementservice.core.port.AccountPort;
import com.wallet.accountmanagementservice.core.port.RabbitMqPort;
import com.wallet.accountmanagementservice.core.port.impl.AccountPortRepository;
import com.wallet.accountmanagementservice.core.port.impl.RabbitMqPortImpl;
import com.wallet.accountmanagementservice.core.service.AccountService;
import com.wallet.accountmanagementservice.core.service.impl.AccountServiceImpl;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceBeanConfig {
    @Bean
    public AccountService accountService(AccountPort port, RabbitMqPort rabbitMqPort){
        return new AccountServiceImpl(port, rabbitMqPort);
    }

    @Bean
    public AccountPort accountPort(AccountRepository repository){
        return new AccountPortRepository(repository);
    }

    @Bean
    public RabbitMqPort rabbitMqPort(RabbitTemplate rabbitTemplate){
        return new RabbitMqPortImpl(rabbitTemplate);
    }
}
