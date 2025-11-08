package com.example.domain.member.model;

public record VirtualAccount(
        PaymentMethodId paymentMethodId,
        MemberId memberId,
        boolean isRecurringPaymentAgreed,
        String bankName,
        String accountNumber,
        String accountHolderName
) implements PaymentMethod {
}
