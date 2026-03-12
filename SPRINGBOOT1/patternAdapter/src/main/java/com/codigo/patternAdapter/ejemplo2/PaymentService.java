package com.codigo.patternAdapter.ejemplo2;

public class PaymentService {
    private final PaymentAdapter paymentAdapter;

    public PaymentService(PaymentAdapter paymentAdapter) {
        this.paymentAdapter = paymentAdapter;
    }

    public PaymentResponse getPayment(){
        return paymentAdapter.getPayment();
    }
}
