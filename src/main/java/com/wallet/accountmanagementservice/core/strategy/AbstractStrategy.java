package com.wallet.accountmanagementservice.core.strategy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wallet.accountmanagementservice.core.domain.AccountDomain;
import com.wallet.accountmanagementservice.core.enumerated.TransactionType;
import com.wallet.accountmanagementservice.core.port.AccountPort;
import com.wallet.accountmanagementservice.core.port.RabbitMqPort;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessagePropertiesBuilder;

import java.math.BigDecimal;

public abstract class AbstractStrategy implements ProcessTransactionStrategy {
    protected final AccountPort port;
    protected final RabbitMqPort rabbitMqPort;

    protected AbstractStrategy(AccountPort port, RabbitMqPort rabbitMqPort) {
        this.port = port;
        this.rabbitMqPort = rabbitMqPort;
    }

    protected boolean hasSufficientBalance(AccountDomain accountDomain, BigDecimal value) {
        return accountDomain.getBalance().compareTo(value) >= 0;
    }

    protected Message renderMensagemFila(Object dto) throws JsonProcessingException {
        var mapperObj = new ObjectMapper();

        return MessageBuilder.withBody(mapperObj.writeValueAsBytes(dto))
                .andProperties(MessagePropertiesBuilder.newInstance().setContentType("application/json")
                        .setContentEncodingIfAbsent("UTF-8").build())
                .build();
    }

    protected void sendToRabbit(Object message, TransactionType transactionType) {
        try {
            rabbitMqPort.send(renderMensagemFila(message), transactionType.toString());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
