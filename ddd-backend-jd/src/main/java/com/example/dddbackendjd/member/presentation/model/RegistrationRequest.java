package com.example.dddbackendjd.member.presentation.model;

public record RegistrationRequest(
        RegisterMemberRequest member,
        RegisterPaymentMethodRequest paymentMethod,
        RegisterProofRequest proof
) {
}
