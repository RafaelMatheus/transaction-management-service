package com.wallet.transactionmanagementservice.adapter.consumer;

import com.wallet.transactionmanagementservice.core.domain.TransactionRabbitMqDomain;
import com.wallet.transactionmanagementservice.core.helper.Mapper;
import com.wallet.transactionmanagementservice.core.service.TransactionService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionConsumer {
    private final TransactionService service;

    public TransactionConsumer(TransactionService service) {
        this.service = service;
    }

    @RabbitListener(queues = "${transaction.rabbit.queue-name}")
    public void transactionConsumer(TransactionRabbitMqDomain domain){
        service.executeAccountTransaction(Mapper.toDomain(domain));
    }
}
