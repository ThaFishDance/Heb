package com.tcb.heb;

public class PayPalPaymentService implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("Paypal");
        System.out.println("Amount: " + amount);
    }
}
