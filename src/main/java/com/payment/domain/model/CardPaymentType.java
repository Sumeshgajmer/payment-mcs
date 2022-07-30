package com.payment.domain.model;

import com.payment.domain.exception.PaymentTypeNotFoundException;

import java.util.HashMap;
import java.util.Map;

public enum CardPaymentType {
    MASTER_CARD(1),
    VISIT_CARD(2),
    AMEX_CARD(3),
    GIFT_CARD(4);
    private final int value;
    private static final Map<Integer, CardPaymentType> map = new HashMap<>();

    CardPaymentType(int value) {
        this.value = value;
    }

    static {
        for (CardPaymentType cardPaymentType : CardPaymentType.values()) {
            map.put(cardPaymentType.value, cardPaymentType);
        }
    }

    public static CardPaymentType valueOf(int cardPaymentType) {
        if(map.containsKey(cardPaymentType)) {
            return  map.get(cardPaymentType);
        }
        throw new PaymentTypeNotFoundException("The Card Payment type with number " +
                cardPaymentType + " is not provided at the moment.");
    }

    public int getValue() {
        return value;
    }
}
