package com.payment.domain.model;

import com.payment.domain.exception.PaymentTypeNotFoundException;

import java.util.HashMap;
import java.util.Map;

public enum PaymentType {
    CASH(1),
    CARD(2);
    private final int value;
    private static final Map<Integer, PaymentType> map = new HashMap<>();

    PaymentType(int value) {
        this.value = value;
    }

    static {
        for (PaymentType paymentType : PaymentType.values()) {
            map.put(paymentType.value, paymentType);
        }
    }

    public static PaymentType valueOf(int paymentType) {
        if(map.containsKey(paymentType)) {
            return  map.get(paymentType);
        }
        throw new PaymentTypeNotFoundException("The Payment type with number " +
                paymentType + " is not provided at the moment.");
    }

    public int getValue() {
        return value;
    }
}
