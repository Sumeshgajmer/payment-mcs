package com.payment.adapter;

import com.payment.domain.model.PaymentType;
import com.payment.domain.model.SurchargeResponse;
import com.payment.domain.port.PaymentSurcharge;

public class CashPaymentSurchargeAdapter implements PaymentSurcharge {

    @Override
    public SurchargeResponse calculateSurcharge(double amount) {
        return SurchargeResponse.with(0, PaymentType.CASH.name(), PaymentType.CASH.name());
    }

}
