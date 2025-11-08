package com.example.domain.member.model;

import com.example.domain.member.enums.TaxType;

import java.util.Objects;

public record TaxInvoice(
        ProofId proofId,
        MemberId memberId,
        boolean isAutomatedIssuance,
        String memberType,
        TaxType taxType,
        String registrationNumber,
        String tradeName,
        String representativeName,
        String itemName,
        String issuanceType
) implements Proof {

    public TaxInvoice {
        Objects.requireNonNull(memberId, "memberId is null");
        Objects.requireNonNull(memberType, "memberType is null");
        Objects.requireNonNull(taxType, "taxType is null");
        Objects.requireNonNull(registrationNumber, "registrationNumber is null");
        Objects.requireNonNull(tradeName, "tradeName is null");
        Objects.requireNonNull(representativeName, "representativeName is null");
        Objects.requireNonNull(itemName, "itemName is null");
        Objects.requireNonNull(issuanceType, "issuanceType is null");
    }
}
