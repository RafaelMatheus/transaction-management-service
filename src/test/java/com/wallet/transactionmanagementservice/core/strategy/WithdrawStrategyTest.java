package com.wallet.transactionmanagementservice.core.strategy;

import com.wallet.transactionmanagementservice.core.port.TransactionPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.wallet.transactionmanagementservice.core.base.BaseTest.getDomain;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class WithdrawStrategyTest {
    @InjectMocks
    private WithdrawStrategy withdrawStrategy;

    @Mock
    private TransactionPort port;

    @Test
    void process() {

        withdrawStrategy.process(getDomain());

        verify(port).save(any());
    }
}