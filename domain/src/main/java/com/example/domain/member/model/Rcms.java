package com.example.domain.member.model;

import com.example.domain.member.enums.AccountHolderType;

public record Rcms(
        PaymentMethodId paymentMethodId,
        MemberId memberId,
        boolean isRecurringPaymentAgreed,
        String bankName,
        String accountNumber,
        String accountHolderName,
        AccountHolderType accountHolderType,
        String dateOfBirth,
        String businessRegistrationNumber,
        String consentInformation
) implements PaymentMethod {
}
