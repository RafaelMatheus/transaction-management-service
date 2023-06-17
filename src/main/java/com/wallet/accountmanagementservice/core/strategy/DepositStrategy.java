package com.wallet.accountmanagementservice.core.strategy;

import com.wallet.accountmanagementservice.core.domain.AccountDomain;
import com.wallet.accountmanagementservice.core.domain.TransactionRabbitMqDomain;
import com.wallet.accountmanagementservice.core.enumerated.TransactionType;
import com.wallet.accountmanagementservice.core.port.AccountPort;
import com.wallet.accountmanagementservice.core.port.RabbitMqPort;

import java.math.BigDecimal;

public class DepositStrategy extends AbstractStrategy {

    public DepositStrategy(AccountPort port, RabbitMqPort rabbitMqPort) {
        super(port, rabbitMqPort);
    }

    @Override
    public AccountDomain process(String destinationAccountNumber, String originAccountNumber, BigDecimal value) {
        var account = port.findByAccountNumber(destinationAccountNumber);

        account.setBalance(account.getBalance().add(value));
        var message = toTransactionRabbitDomainDeposit(account, value);
        sendToRabbit(message, message.getTransactionType());
        return port.save(account);
    }

    @Override
    public TransactionType getType() {
        return TransactionType.DEPOSIT;
    }

    private TransactionRabbitMqDomain toTransactionRabbitDomainDeposit(AccountDomain destinationAccount, BigDecimal value) {
        return new TransactionRabbitMqDomain(TransactionType.DEPOSIT, null, destinationAccount.getAccountNumber(), value);
    }
}
