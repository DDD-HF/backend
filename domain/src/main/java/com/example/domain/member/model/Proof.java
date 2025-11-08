package com.example.domain.member.model;

public sealed interface Proof permits CashReceipt, TaxInvoice {

    ProofId proofId();
    MemberId memberId();
    boolean isAutomatedIssuance();
}
