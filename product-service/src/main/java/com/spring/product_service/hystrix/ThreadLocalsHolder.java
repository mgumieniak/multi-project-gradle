package com.spring.product_service.hystrix;

public class ThreadLocalsHolder {
    private static final ThreadLocal<String> CORRELATION_ID = new ThreadLocal<>();

    public static void setCorrelationId(String correlationId) {
        CORRELATION_ID.set(correlationId);
    }

    public static String getCorrelationId() {
        return CORRELATION_ID.get();
    }
}

