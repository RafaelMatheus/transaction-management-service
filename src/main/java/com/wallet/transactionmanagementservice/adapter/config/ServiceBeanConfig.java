package com.wallet.transactionmanagementservice.adapter.config;

import com.wallet.transactionmanagementservice.adapter.repository.TransactionRepository;
import com.wallet.transactionmanagementservice.core.port.TransactionPort;
import com.wallet.transactionmanagementservice.core.port.impl.TransactionPortRepository;
import com.wallet.transactionmanagementservice.core.service.TransactionService;
import com.wallet.transactionmanagementservice.core.service.impl.TransactionServiceImpl;
import com.wallet.transactionmanagementservice.core.strategy.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class ServiceBeanConfig {
    @Bean
    public TransactionService transactionService(TransactionFactory factory, TransactionPortRepository repository) {
        return new TransactionServiceImpl(factory, repository);
    }

    @Bean
    public TransactionFactory factory(Set<ProcessTransactionStrategy> processTransactionStrategies) {
        return new TransactionFactory(processTransactionStrategies);
    }

    @Bean
    public TransactionPort transactionPort(TransactionRepository repository) {
        return new TransactionPortRepository(repository);
    }

    @Bean
    public Set<ProcessTransactionStrategy> strategies(TransactionPort port) {
        var depositStrategy = new DepositStrategy(port);
        var withdrawStrategy = new WithdrawStrategy(port);
        var transferStrategy = new TransferStrategy(port);
        var paymentStrategy = new PaymentStrategy(port);
        return Set.of(depositStrategy, withdrawStrategy, transferStrategy, paymentStrategy);
    }
}
