package com.wallet.transactionmanagementservice.core.helper;

import org.junit.jupiter.api.Test;

import static com.wallet.transactionmanagementservice.core.base.BaseTest.getDomain;
import static com.wallet.transactionmanagementservice.core.base.BaseTest.getEntity;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MapperTest {

    @Test
    void toEntity() {
        var domain = getDomain();

        var response = Mapper.toEntity(domain);

        assertAll(() -> assertEquals(domain.originAccountNumber(), response.getOriginAccountNumber()),
                () -> assertEquals(domain.type(), response.getType()),
                () -> assertEquals(domain.value(), response.getAmount()));
    }

    @Test
    void toDomain() {
        var entity = getEntity();

        var response = Mapper.toDomain(entity);

        assertAll(() -> assertEquals(entity.getOriginAccountNumber(), response.originAccountNumber()),
                () -> assertEquals(entity.getType(), response.type()),
                () -> assertEquals(entity.getAmount(), response.value()));
    }
}