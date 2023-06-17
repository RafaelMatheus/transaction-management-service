package com.wallet.accountmanagementservice.adapter.helper;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQHelper {
    private final RabbitTemplate template;

    public RabbitMQHelper(RabbitTemplate template) {
        this.template = template;
    }

    public void convertAndSend(){
    }
}
