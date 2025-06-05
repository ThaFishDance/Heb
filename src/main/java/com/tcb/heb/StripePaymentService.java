package com.tcb.heb;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

// Bean Configuration in AppConfig
public class StripePaymentService implements PaymentService {

    @Value("${stripe.apiUrl}")
    private String stripeApiUrl;

    @Value("${stripe.enabled}")
    private boolean stripeEnabled;

    @Value("${stripe.timeout:3000}")
    private int stripeTimeout;

    @Value("${stripe.supported-currencies}")
    private List<String> stripeSupportedCurrencies;

    @Override
    public void processPayment(double amount){
        System.out.println("STRIPE");
        System.out.println(stripeApiUrl);
        System.out.println(stripeEnabled);
        System.out.println(stripeTimeout);
        System.out.println(stripeSupportedCurrencies);
        System.out.println("Amount: " + amount);
    }
}
