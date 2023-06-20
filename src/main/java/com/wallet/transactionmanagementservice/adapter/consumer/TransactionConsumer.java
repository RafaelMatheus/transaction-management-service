package com.wallet.transactionmanagementservice.adapter.consumer;

import com.wallet.transactionmanagementservice.core.domain.TransactionRabbitMqDomain;
import com.wallet.transactionmanagementservice.core.helper.Mapper;
import com.wallet.transactionmanagementservice.core.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionConsumer {
    private final Logger log = LoggerFactory.getLogger(TransactionConsumer.class);
    private final TransactionService service;

    public TransactionConsumer(TransactionService service) {
        this.service = service;
    }

    @RabbitListener(queues = "${transaction.rabbit.queue-name}")
    public void transactionConsumer(TransactionRabbitMqDomain domain){
        log.info("m=transactionConsumer, step=initProcessing");
        service.executeAccountTransaction(Mapper.toDomain(domain));
        log.info("m=transactionConsumer, step=finished");
    }
}
