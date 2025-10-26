package com.example.dddbackendjd.member.domain.api.dto;

import com.example.dddbackendjd.member.domain.enums.ProofType;
import com.example.dddbackendjd.member.domain.enums.TaxType;
import org.springframework.util.Assert;

public record ProofCommand() {

    public record Register(
            ProofType proofType,
            CashReceipt cashReceipt,
            TaxInvoice taxInvoice
    ) {

        public Register {
            Assert.notNull(proofType, "proofType must not be null");
            switch (proofType) {
                case 현금영수증 -> Assert.notNull(cashReceipt, "cashReceipt must not be null");
                case 세금계산서 -> Assert.notNull(taxInvoice, "taxInvoice must not be null");
            }
        }

        public record CashReceipt(
                boolean isAutomatedIssuance,
                String cashReceiptInformation
        ) {

            public CashReceipt {
                Assert.notNull(cashReceiptInformation, "cashReceiptInformation must not be null");
            }
        }

        public record TaxInvoice(
                String memberType,
                TaxType taxType,
                String registrationNumber,
                String tradeName,
                String representativeName,
                String itemName,
                String issuanceType,
                String issuanceMethod
        ) {
            public TaxInvoice {
                Assert.notNull(memberType, "memberType must not be null");
                Assert.notNull(taxType, "taxType must not be null");
                Assert.notNull(registrationNumber, "registrationNumber must not be null");
                Assert.notNull(tradeName, "tradeName must not be null");
                Assert.notNull(representativeName, "representativeName must not be null");
                Assert.notNull(itemName, "itemName must not be null");
                Assert.notNull(issuanceType, "issuanceType must not be null");
                Assert.notNull(issuanceMethod, "issuanceMethod must not be null");
            }
        }
    }
}
