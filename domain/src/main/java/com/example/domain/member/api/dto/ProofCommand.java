package com.example.domain.member.api.dto;

import com.example.domain.member.enums.ProofType;
import com.example.domain.member.enums.TaxType;
import com.example.domain.member.model.MemberId;

import java.util.Objects;

public record ProofCommand() {

    public record Register(
            MemberId memberId,
            ProofType proofType,
            CashReceipt cashReceipt,
            TaxInvoice taxInvoice
    ) {

        public Register {
            Objects.requireNonNull(proofType, "proofType must not be null");
            switch (proofType) {
                case 현금영수증 -> Objects.requireNonNull(cashReceipt, "cashReceipt must not be null");
                case 세금계산서 -> Objects.requireNonNull(taxInvoice, "taxInvoice must not be null");
            }
        }

        public record CashReceipt(
                boolean isAutomatedIssuance,
                String cashReceiptInformation
        ) {

            public CashReceipt {
                Objects.requireNonNull(cashReceiptInformation, "cashReceiptInformation must not be null");
            }
        }

        public record TaxInvoice(
                boolean isAutomatedIssuance,
                String memberType,
                TaxType taxType,
                String registrationNumber,
                String tradeName,
                String representativeName,
                String itemName,
                String issuanceType
        ) {
            public TaxInvoice {
                Objects.requireNonNull(memberType, "memberType must not be null");
                Objects.requireNonNull(taxType, "taxType must not be null");
                Objects.requireNonNull(registrationNumber, "registrationNumber must not be null");
                Objects.requireNonNull(tradeName, "tradeName must not be null");
                Objects.requireNonNull(representativeName, "representativeName must not be null");
                Objects.requireNonNull(itemName, "itemName must not be null");
                Objects.requireNonNull(issuanceType, "issuanceType must not be null");
            }
        }
    }
}
