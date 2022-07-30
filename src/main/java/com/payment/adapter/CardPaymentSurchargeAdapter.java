package com.payment.adapter;

import com.payment.domain.model.CardPaymentType;
import com.payment.domain.model.PaymentType;
import com.payment.domain.model.SurchargeResponse;
import com.payment.domain.port.PaymentSurcharge;
import com.payment.util.InputUtil;

public class CardPaymentSurchargeAdapter implements PaymentSurcharge {

    @Override
    public SurchargeResponse calculateSurcharge(double amount) {
        var intCardType = InputUtil.inputIntValue("From which card will you pay?\n" +
                "-------------------------------\n" +
                "Enter 1 for  Master Card\n" +
                "Enter 2 for  Visit Card\n" +
                "Enter 3 for  Amex Card\n" +
                "Enter 4 for  Gift Card\n"
        );
        var cardPaymentType = CardPaymentType.valueOf(intCardType);
        var surchargeAmt = getChargeFrom(amount, cardPaymentType);
        return SurchargeResponse.with(surchargeAmt, PaymentType.CARD.name(), cardPaymentType.name());
    }

    private double getChargeFrom(double amount, CardPaymentType cardPaymentType) {
        switch (cardPaymentType) {
            case MASTER_CARD:
            case VISIT_CARD:
                return (amount * 1.5) / 100;
            case AMEX_CARD:
                return (amount * 3) / 100;
            case GIFT_CARD:
                return amount;
        }
        return amount;
    }
}
