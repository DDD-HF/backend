package com.example.domain.member.api.dto;

import com.example.domain.member.model.Member;
import com.example.domain.member.model.MemberId;

import java.util.Objects;

public record MemberCommand() {

    public record Register(
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
        public Register {
            Objects.requireNonNull(status, "status must not be null");
            Objects.requireNonNull(name, "name must not be null");
            Objects.requireNonNull(memberNumber, "memberNumber must not be null");
            Objects.requireNonNull(mobileNumber, "mobileNumber must not be null");
            Objects.requireNonNull(registrationDate, "registrationDate must not be null");
        }
    }

    public record Update(
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

    public record Delete(
            MemberId memberId
    ) {
    }

}


