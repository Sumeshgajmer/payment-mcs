package com.payment.domain.port;

import com.payment.domain.model.SurchargeResponse;

public interface PaymentSurcharge {
    SurchargeResponse calculateSurcharge(double amount);
}
