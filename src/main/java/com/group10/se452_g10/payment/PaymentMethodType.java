package com.group10.se452_g10.payment;

public enum PaymentMethodType {
    CREDIT_CARD("Credit Card"),
    DEBIT_CARD("Debit Card"),
    NET_BANKING("Net Banking");

    private String description;

    PaymentMethodType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}