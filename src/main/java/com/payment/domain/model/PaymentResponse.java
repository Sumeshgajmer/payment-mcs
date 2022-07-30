package com.payment.domain.model;

public class PaymentResponse {
    private double originalAmount;
    private double deliveryCharge;
    private double totalAmount;
    private double surcharge;
    private String createdAt;
    private PaymentType paymentType;
    private String paymentSubType;

    private PaymentResponse(double deliveryCharge, double totalAmount, double surcharge,
                            String createdAt, PaymentType paymentType, String paymentSubType,
                            double originalAmount) {
        this.deliveryCharge = deliveryCharge;
        this.totalAmount = totalAmount;
        this.surcharge = surcharge;
        this.createdAt = createdAt;
        this.paymentType = paymentType;
        this.paymentSubType = paymentSubType;
        this.originalAmount = originalAmount;
    }

    public double getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(double deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(double surcharge) {
        this.surcharge = surcharge;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentSubType() {
        return paymentSubType;
    }

    public void setPaymentSubType(String paymentSubType) {
        this.paymentSubType = paymentSubType;
    }

    public double getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(double originalAmount) {
        this.originalAmount = originalAmount;
    }

    public static PaymentResponse with(double deliveryCharge,
                                       double totalAmount,
                                       double surcharge,
                                       String createdAt,
                                       PaymentType paymentType,
                                       String paymentSubType,
                                       double originalAmount) {
        return new PaymentResponse(deliveryCharge, totalAmount, surcharge, createdAt, paymentType, paymentSubType, originalAmount);
    }

    public static PaymentResponse with(double deliveryCharge,
                                       double totalAmount,
                                       double surcharge,
                                       String createdAt,
                                       PaymentType paymentType,
                                       double originalAmount) {
        return new PaymentResponse(deliveryCharge, totalAmount, surcharge, createdAt, paymentType, null, originalAmount);
    }


    @Override
    public String toString() {
        var string = "You got payment Response with \n" +
                "--------------------------------------\n" +
                " Input Amount =" + originalAmount +
                ", \n Delivery Charge = " + deliveryCharge +
                ", \n Total Amount = " + totalAmount +
                ", \n Surcharge = " + surcharge +
                ", \n Date = " + createdAt +
                ", \n Payment Type = " + paymentType;
        if (this.paymentType == PaymentType.CARD)
            return string + "\n Payment SubType = " + paymentSubType;
        return string;
    }
}
