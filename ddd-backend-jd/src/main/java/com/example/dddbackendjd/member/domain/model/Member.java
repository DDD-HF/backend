package com.example.dddbackendjd.member.domain.model;

import lombok.Builder;

@Builder(toBuilder = true)
public record Member(
        MemberId memberId,
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
