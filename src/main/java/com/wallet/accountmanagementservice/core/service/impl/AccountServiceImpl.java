package com.wallet.accountmanagementservice.core.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wallet.accountmanagementservice.core.domain.AccountDomain;
import com.wallet.accountmanagementservice.core.helper.Mapper;
import com.wallet.accountmanagementservice.core.port.AccountPort;
import com.wallet.accountmanagementservice.core.port.RabbitMqPort;
import com.wallet.accountmanagementservice.core.service.AccountService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessagePropertiesBuilder;

import java.math.BigDecimal;
import java.util.UUID;

public class AccountServiceImpl implements AccountService {
    private final AccountPort port;
    private final RabbitMqPort rabbitMqPort;

    public AccountServiceImpl(AccountPort port, RabbitMqPort rabbitMqPort) {
        this.port = port;
        this.rabbitMqPort = rabbitMqPort;
    }

    @Override
    public AccountDomain generateAccount(AccountDomain accountDomain) {
        accountDomain.setAccountNumber(UUID.randomUUID().toString());
        accountDomain.setBalance(BigDecimal.ZERO);
        return port.save(accountDomain);
    }

    @Override
    public AccountDomain getAccountInformation(String accountNumber) {
        return null;
    }

    @Override
    public AccountDomain withdrawFunds(String accountNumberOrigin, String accountNumberDestiny) {

        try {
            var account = new AccountDomain();
            rabbitMqPort.send(renderMensagemFila(account), "teste");
            return null;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deposit(String destinationAccountNumber, BigDecimal value) {
        try {
            var account = port.findByAccountNumber(destinationAccountNumber);
            account.setBalance(account.getBalance().add(value));
            var message = Mapper.toTransactionRabbitDomainDeposit(account, value);
            rabbitMqPort.send(renderMensagemFila(message), message.getTransactionType().toString());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private Message renderMensagemFila(Object dto) throws JsonProcessingException {
        var mapperObj = new ObjectMapper();

        return MessageBuilder.withBody(mapperObj.writeValueAsBytes(dto))
                .andProperties(MessagePropertiesBuilder.newInstance().setContentType("application/json")
                        .setContentEncodingIfAbsent("UTF-8").build())
                .build();
    }
}
