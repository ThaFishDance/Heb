package com.tcb.heb;


import org.springframework.beans.factory.annotation.Qualifier;

//@Service
public class OrderService {

    private PaymentService paymentService;

    public OrderService(@Qualifier("stripe") PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder() {
        this.paymentService.processPayment(10);
    }

    public PaymentService getPaymentService() {
        return paymentService;
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
