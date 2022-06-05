package br.com.ffseguros.apistoragebikes.application.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class SchedulingTest {

    @Test
    void shouldInstantiateSchedulingWithNoArguments() {
        var scheduling = new Scheduling();
        assertNotNull(scheduling);
    }

}