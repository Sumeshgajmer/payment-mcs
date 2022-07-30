package com.payment.usecase;

import com.payment.domain.exception.InvalidArgumentException;
import com.payment.domain.model.PaymentReq;
import com.payment.domain.model.PaymentResponse;
import com.payment.domain.model.PaymentType;
import com.payment.domain.model.SurchargeResponse;
import com.payment.util.DateUtil;

public class PaymentInteractor implements PaymentUseCase {

    @Override
    public PaymentResponse paymentCalculation(PaymentReq request) {
        validatePaymentRequest(request);
        var paymentType = request.getPaymentType();
        var amount = request.getAmount();
        var surcharge = PaymentAdapterProvider.getPayment(paymentType)
                .calculateSurcharge(amount);
        var deliveryChange = request.deliverCharge(amount);
        var totalAmount = amount + surcharge.getSurchargeAmt() + deliveryChange;
        return buildPaymentResponse(deliveryChange, totalAmount, surcharge, amount);
    }

    private void validatePaymentRequest(PaymentReq request) {
        if (request == null)
            throw new InvalidArgumentException("Payment Request cannot be null");
        if (request.getPaymentType() == null)
            throw new InvalidArgumentException("Payment type cannot be null");
        if (request.getAmount() == 0)
            throw new InvalidArgumentException("Please provide the amount more than 0");
    }

    private PaymentResponse buildPaymentResponse(double deliveryChange, double totalAmount, SurchargeResponse surcharge, double originalAmount) {
        var paymentType = PaymentType.valueOf(surcharge.getPaymentType());
        var date = DateUtil.getCurrentDate();
        if (paymentType == PaymentType.CASH) {
            return PaymentResponse.with(deliveryChange, totalAmount,
                    surcharge.getSurchargeAmt(), date, paymentType, originalAmount);
        }
        return PaymentResponse.with(deliveryChange, totalAmount,
                surcharge.getSurchargeAmt(), date, paymentType,
                surcharge.getPaymentSubType(), originalAmount);
    }
}

