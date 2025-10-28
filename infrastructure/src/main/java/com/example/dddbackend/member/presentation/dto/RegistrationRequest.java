package com.example.dddbackend.member.presentation.dto;

public record RegistrationRequest(
        RegisterMemberRequest member,
        RegisterPaymentMethodRequest paymentMethod,
        RegisterProofRequest proof
) {
}
