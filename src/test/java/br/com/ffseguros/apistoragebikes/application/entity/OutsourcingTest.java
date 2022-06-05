package br.com.ffseguros.apistoragebikes.application.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class OutsourcingTest {

    @Test
    void shouldInstantiateOutsourcingWithNoArguments() {
        var outsourcing = new Outsourcing();
        assertNotNull(outsourcing);
    }

}