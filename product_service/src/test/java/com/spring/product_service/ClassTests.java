package com.spring.product_service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassTests {

    @ParameterizedTest(name = "For example, year {0} is not supported.")
    @ValueSource(booleans = {true, true, true})
    void name(boolean status) {
        assertThat(status).isTrue();
    }
}
