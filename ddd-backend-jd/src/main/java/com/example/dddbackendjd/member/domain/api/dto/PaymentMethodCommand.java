package com.example.dddbackendjd.member.domain.api.dto;

import com.example.dddbackendjd.member.domain.enums.AccountHolderType;
import com.example.dddbackendjd.member.domain.enums.CardHolderType;
import com.example.dddbackendjd.member.domain.enums.PaymentMethodType;
import org.springframework.util.Assert;

public record PaymentMethodCommand() {

    public record Register(
            PaymentMethodType paymentMethodType,
            Cms cms,
            Rcms rcms,
            Card card,
            Mobile mobile,
            VirtualAccount virtualAccount
    ) {

        public Register {
            Assert.notNull(paymentMethodType, "paymentMethodType must not be null");
            switch (paymentMethodType) {
                case CMS -> Assert.notNull(cms, "cms must not be null");
                case 실시간CMS -> Assert.notNull(rcms, "rcms must not be null");
                case 카드 -> Assert.notNull(card, "card must not be null");
                case 휴대전화 -> Assert.notNull(mobile, "mobile must not be null");
                case 가상계좌 -> Assert.notNull(virtualAccount, "virtualAccount must not be null");
            }
        }

        public record Cms(
                String bankName,
                String accountNumber,
                String accountHolderName,
                AccountHolderType accountHolderType,
                String dateOfBirth,
                String businessRegistrationNumber,
                String consentInformation
        ) {

            public Cms {
                Assert.notNull(bankName, "bankName must not be null");
                Assert.notNull(accountNumber, "accountNumber must not be null");
                Assert.notNull(accountHolderName, "accountHolderName must not be null");
                Assert.notNull(accountHolderType, "accountHolderType must not be null");
                switch (accountHolderType) {
                    case 개인 -> Assert.notNull(dateOfBirth, "dateOfBirth must not be null");
                    case 법인 ->
                            Assert.notNull(businessRegistrationNumber, "businessRegistrationNumber must not be null");
                }
                Assert.notNull(consentInformation, "consentInformation must not be null");
            }
        }

        public record Rcms(
                String bankName,
                String accountNumber,
                String accountHolderName,
                AccountHolderType accountHolderType,
                String dateOfBirth,
                String businessRegistrationNumber,
                String consentInformation
        ) {

            public Rcms {
                Assert.notNull(bankName, "bankName must not be null");
                Assert.notNull(accountNumber, "accountNumber must not be null");
                Assert.notNull(accountHolderName, "accountHolderName must not be null");
                Assert.notNull(accountHolderType, "accountHolderType must not be null");
                switch (accountHolderType) {
                    case 개인 -> Assert.notNull(dateOfBirth, "dateOfBirth must not be null");
                    case 법인 ->
                            Assert.notNull(businessRegistrationNumber, "businessRegistrationNumber must not be null");
                }
                Assert.notNull(consentInformation, "consentInformation must not be null");
            }
        }

        public record Card(
                String cardNumber,
                String cardHolderName,
                CardHolderType cardHolderType,
                String dateOfBirth,
                String businessRegistrationNumber
        ) {

            public Card {
                Assert.notNull(cardNumber, "cardNumber must not be null");
                Assert.notNull(cardHolderName, "cardHolderName must not be null");
                Assert.notNull(cardHolderType, "cardHolderType must not be null");
                switch (cardHolderType) {
                    case 개인 -> Assert.notNull(dateOfBirth, "dateOfBirth must not be null");
                    case 법인 -> Assert.notNull(businessRegistrationNumber, "businessRegistrationNumber must not be null");
                }
            }
        }

        public record Mobile(
                String telecomCompany,
                String mobileNumber,
                String residentRegistrationNumber,
                String mobileHolderName
        ) {

            public Mobile {
                Assert.notNull(telecomCompany, "telecomCompany must not be null");
                Assert.notNull(mobileNumber, "mobileNumber must not be null");
                Assert.notNull(residentRegistrationNumber, "residentRegistrationNumber must not be null");
                Assert.notNull(mobileHolderName, "mobileHolderName must not be null");
            }
        }

        public record VirtualAccount(
                String bankName,
                String accountNumber,
                String accountHolderName
        ) {
            public VirtualAccount {
                Assert.notNull(bankName, "bankName must not be null");
                Assert.notNull(accountNumber, "accountNumber must not be null");
                Assert.notNull(accountHolderName, "accountHolderName must not be null");
            }
        }
    }
}
