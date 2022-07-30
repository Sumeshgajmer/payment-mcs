package com.payment.domain.model;

public class PaymentReq {
    private double amount;
    private PaymentType paymentType;

    public PaymentReq(double amount, PaymentType paymentType) {
        this.amount = amount;
        this.paymentType = paymentType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public double deliverCharge(double amount) {
        if (amount < 50) {
            return 10;
        } else if (amount >= 50 && amount < 100) {
           return 5;
        } else {
            return 0;
        }
    }
}

