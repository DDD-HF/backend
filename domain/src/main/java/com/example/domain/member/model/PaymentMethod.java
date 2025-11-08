package com.example.domain.member.model;

public sealed interface PaymentMethod permits Cms, Rcms, Card, Mobile, VirtualAccount, PayerPayment {

    PaymentMethodId paymentMethodId();
    MemberId memberId();
    boolean isRecurringPaymentAgreed();
}
