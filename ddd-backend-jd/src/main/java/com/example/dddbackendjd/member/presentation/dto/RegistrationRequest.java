package com.example.dddbackendjd.member.presentation.dto;

public record RegistrationRequest(
        RegisterMemberRequest member,
        RegisterPaymentMethodRequest paymentMethod,
        RegisterProofRequest proof
) {
}
