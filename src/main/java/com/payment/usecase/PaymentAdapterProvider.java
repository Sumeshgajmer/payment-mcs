package com.payment.usecase;

import com.payment.adapter.CardPaymentSurchargeAdapter;
import com.payment.adapter.CashPaymentSurchargeAdapter;
import com.payment.domain.exception.PaymentTypeNotFoundException;
import com.payment.domain.model.PaymentType;
import com.payment.domain.port.PaymentSurcharge;

import java.util.HashMap;
import java.util.Map;

public class PaymentAdapterProvider {
    private static final Map<PaymentType, PaymentSurcharge> PAYMENT_MAP = new HashMap<>();

    private PaymentAdapterProvider() {
    }

    static {
        PAYMENT_MAP.put(PaymentType.CASH, new CashPaymentSurchargeAdapter());
        PAYMENT_MAP.put(PaymentType.CARD, new CardPaymentSurchargeAdapter());
    }

    public static PaymentSurcharge getPayment(PaymentType paymentType) {
        if (PAYMENT_MAP.containsKey(paymentType))
            return PAYMENT_MAP.get(paymentType);
        throw new PaymentTypeNotFoundException("Payment not found");
    }
}
