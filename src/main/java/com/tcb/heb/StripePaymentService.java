package com.tcb.heb;

import org.springframework.beans.factory.annotation.Value;

//@Service("stripe")
//@Primary
public class StripePaymentService implements PaymentService {

    @Value("${stripe.apiUrl}")
    private String stripeApiUrl;

    @Override
    public void processPayment(double amount){
        System.out.println("STRIPE");
        System.out.println("Amount: " + amount);
    }
}
