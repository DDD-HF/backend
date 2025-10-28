package com.example.dddbackend.member.presentation.dto;

public record RegisterProofRequest(
        String proofType,
        CashReceipt cashReceipt,
        TaxInvoice taxInvoice
) {

    public record CashReceipt(
            boolean isAutomatedIssuance,
            String cashReceiptInformation
    ) {
    }

    public record TaxInvoice(
            String memberType,
            String taxType,
            String registrationNumber,
            String tradeName,
            String representativeName,
            String itemName,
            String issuanceType,
            String issuanceMethod
    ) {
    }
}
