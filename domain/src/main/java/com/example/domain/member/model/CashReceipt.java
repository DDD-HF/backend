package com.example.domain.member.model;

import java.util.Objects;

public record CashReceipt(
        ProofId proofId,
        MemberId memberId,
        boolean isAutomatedIssuance,
        String cashReceiptInformation
) implements Proof {

    public CashReceipt {
        Objects.requireNonNull(memberId, "memberId is null");
        Objects.requireNonNull(cashReceiptInformation, "cashReceiptInformation is null");
    }
}
