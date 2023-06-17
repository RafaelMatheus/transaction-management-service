package com.wallet.accountmanagementservice.core.strategy;

import com.wallet.accountmanagementservice.core.domain.AccountDomain;
import com.wallet.accountmanagementservice.core.domain.TransactionRabbitMqDomain;
import com.wallet.accountmanagementservice.core.enumerated.TransactionType;
import com.wallet.accountmanagementservice.core.exception.IinsufficientBalanceException;
import com.wallet.accountmanagementservice.core.port.AccountPort;
import com.wallet.accountmanagementservice.core.port.RabbitMqPort;

import java.math.BigDecimal;

public class TransferStrategy extends AbstractStrategy {
    public TransferStrategy(AccountPort port, RabbitMqPort rabbitMqPort) {
        super(port, rabbitMqPort);
    }

    @Override
    public AccountDomain process(String destinationAccountNumber, String originAccountNumber, BigDecimal value) {
        var destinationAccount = port.findByAccountNumber(destinationAccountNumber);
        var originAccount = port.findByAccountNumber(originAccountNumber);

        if (!hasSufficientBalance(originAccount, value)) {
            throw new IinsufficientBalanceException();
        }

        destinationAccount.setBalance(destinationAccount.getBalance().add(value));

        var message = toTransactionRabbitDomainDeposit(originAccount, destinationAccount, value);
        sendToRabbit(message, message.getTransactionType());
        return port.save(destinationAccount);
    }

    @Override
    public TransactionType getType() {
        return TransactionType.TRANSFER;
    }

    private TransactionRabbitMqDomain toTransactionRabbitDomainDeposit(AccountDomain originAccount, AccountDomain destinationAccount, BigDecimal value) {
        return new TransactionRabbitMqDomain(TransactionType.TRANSFER, originAccount.getAccountNumber(), destinationAccount.getAccountNumber(), value);
    }
}
