package com.example.dddbackend.member.presentation.dto;

public record RegisterMemberRequest(
        String status,
        String name,
        String memberNumber,
        String email,
        String zipCode,
        String address,
        String detailedAddress,
        String mobileNumber,
        String landlineNumber,
        String registrationDate,
        boolean isSmsSendingAllowed,
        String memo
) {
}
