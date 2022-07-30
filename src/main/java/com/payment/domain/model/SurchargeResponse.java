package com.payment.domain.model;

public class SurchargeResponse {
    private double surchargeAmt;
    private String paymentType;
    private String paymentSubType;

    private SurchargeResponse(double surchargeAmt, String paymentType, String paymentSubType) {
        this.surchargeAmt = surchargeAmt;
        this.paymentType = paymentType;
        this.paymentSubType = paymentSubType;
    }

    public double getSurchargeAmt() {
        return surchargeAmt;
    }

    public void setSurchargeAmt(double surchargeAmt) {
        this.surchargeAmt = surchargeAmt;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentSubType() {
        return paymentSubType;
    }

    public void setPaymentSubType(String paymentSubType) {
        this.paymentSubType = paymentSubType;
    }

    public static SurchargeResponse with(double surchargeAmount, String paymentType, String paymentSubType) {
        return new SurchargeResponse(surchargeAmount, paymentType, paymentSubType);
    }
}
