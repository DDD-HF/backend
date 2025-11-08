package com.example.domain.member.model;

public record PayerPayment(
        PaymentMethodId paymentMethodId,
        MemberId memberId,
        boolean isRecurringPaymentAgreed,
        boolean isCardEnabled,
        boolean isAccountEnabled,
        boolean isSimplePaymentEnabled
) implements PaymentMethod {
}
