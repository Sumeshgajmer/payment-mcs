package com.payment;

import com.payment.domain.model.PaymentReq;
import com.payment.domain.model.PaymentType;
import com.payment.usecase.PaymentInteractor;
import com.payment.usecase.PaymentUseCase;
import com.payment.util.InputUtil;

public class ApplicationLaunch {

    public static void main(String[] args) {
        PaymentUseCase paymentUseCase = new PaymentInteractor();
        var intPaymentType = InputUtil.inputIntValue("Enter the following\n " +
                "----------------------------------\n" +
                " 1. Enter 1 for Cash Payment\n" +
                " 2. Enter 2 for Card Payment");
        var paymentType = PaymentType.valueOf(intPaymentType);
        var amount = InputUtil.inputDoubleValue("Enter the amount you want to calculate\n" +
                "-----------------------------------------------");
        var paymentReq = new PaymentReq(amount, paymentType);
        var paymentResponse = paymentUseCase.paymentCalculation(paymentReq);
        System.out.println(paymentResponse);
    }

}
