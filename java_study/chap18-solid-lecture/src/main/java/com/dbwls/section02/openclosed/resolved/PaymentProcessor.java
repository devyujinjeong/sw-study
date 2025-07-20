package com.dbwls.section02.openclosed.resolved;

/* Payment로 받아주기만 하면, 작성한 클래스에 관한 타입이 다 들어오게 된다. */
public class PaymentProcessor {
    public void processPayment(Payment payment) {
        payment.process();
    }
}