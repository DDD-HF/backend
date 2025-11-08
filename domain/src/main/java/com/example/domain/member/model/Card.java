package com.example.domain.member.model;

import com.example.domain.member.enums.CardHolderType;

public record Card(
        PaymentMethodId paymentMethodId,
        MemberId memberId,
        boolean isRecurringPaymentAgreed,
        String cardNumber,
        String cardHolderName,
        CardHolderType cardHolderType,
        String dateOfBirth,
        String businessRegistrationNumber
) implements PaymentMethod {
}
