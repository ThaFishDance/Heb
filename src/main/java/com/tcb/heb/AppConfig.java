package com.tcb.heb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class AppConfig {

    @Value("${payment-gateway: stripe}")
    private String paymentGateway;

    @Bean
    public PaymentService stripe() {
        System.out.println("Creating stripe bean");
        return new StripePaymentService();
    }

    @Bean
    public PaymentService paypal() {
        System.out.println("Creating paypal bean");
        return new PayPalPaymentService();
    }

    @Bean
    public OrderService orderService() {
        return new OrderService(paymentGateway.equals("stripe") ? stripe() : paypal());
    }

    @Bean
    @Lazy
    public HeavyResource heavyResource() {
        return new HeavyResource();
    }
}
