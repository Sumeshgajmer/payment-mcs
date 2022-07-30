package com.payment.domain.exception;

public class PaymentTypeNotFoundException extends RuntimeException{
    public PaymentTypeNotFoundException(String message) {
        super(message);
    }

    public PaymentTypeNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
