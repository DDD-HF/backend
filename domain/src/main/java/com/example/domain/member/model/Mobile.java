package com.example.domain.member.model;

public record Mobile(
        PaymentMethodId paymentMethodId,
        MemberId memberId,
        boolean isRecurringPaymentAgreed,
        String telecomCompany,
        String mobileNumber,
        String residentRegistrationNumber,
        String mobileHolderName
) implements PaymentMethod {
}
