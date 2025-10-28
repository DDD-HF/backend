package com.example.domain.member.api.dto;

import com.example.domain.member.enums.AccountHolderType;
import com.example.domain.member.enums.CardHolderType;
import com.example.domain.member.enums.PaymentMethodType;

import java.util.Objects;

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
            Objects.requireNonNull(paymentMethodType, "paymentMethodType must not be null");
            switch (paymentMethodType) {
                case CMS -> Objects.requireNonNull(cms, "cms must not be null");
                case 실시간CMS -> Objects.requireNonNull(rcms, "rcms must not be null");
                case 카드 -> Objects.requireNonNull(card, "card must not be null");
                case 휴대전화 -> Objects.requireNonNull(mobile, "mobile must not be null");
                case 가상계좌 -> Objects.requireNonNull(virtualAccount, "virtualAccount must not be null");
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
                Objects.requireNonNull(bankName, "bankName must not be null");
                Objects.requireNonNull(accountNumber, "accountNumber must not be null");
                Objects.requireNonNull(accountHolderName, "accountHolderName must not be null");
                Objects.requireNonNull(accountHolderType, "accountHolderType must not be null");
                switch (accountHolderType) {
                    case 개인 -> Objects.requireNonNull(dateOfBirth, "dateOfBirth must not be null");
                    case 법인 ->
                            Objects.requireNonNull(businessRegistrationNumber, "businessRegistrationNumber must not be null");
                }
                Objects.requireNonNull(consentInformation, "consentInformation must not be null");
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
                Objects.requireNonNull(bankName, "bankName must not be null");
                Objects.requireNonNull(accountNumber, "accountNumber must not be null");
                Objects.requireNonNull(accountHolderName, "accountHolderName must not be null");
                Objects.requireNonNull(accountHolderType, "accountHolderType must not be null");
                switch (accountHolderType) {
                    case 개인 -> Objects.requireNonNull(dateOfBirth, "dateOfBirth must not be null");
                    case 법인 ->
                            Objects.requireNonNull(businessRegistrationNumber, "businessRegistrationNumber must not be null");
                }
                Objects.requireNonNull(consentInformation, "consentInformation must not be null");
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
                Objects.requireNonNull(cardNumber, "cardNumber must not be null");
                Objects.requireNonNull(cardHolderName, "cardHolderName must not be null");
                Objects.requireNonNull(cardHolderType, "cardHolderType must not be null");
                switch (cardHolderType) {
                    case 개인 -> Objects.requireNonNull(dateOfBirth, "dateOfBirth must not be null");
                    case 법인 -> Objects.requireNonNull(businessRegistrationNumber, "businessRegistrationNumber must not be null");
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
                Objects.requireNonNull(telecomCompany, "telecomCompany must not be null");
                Objects.requireNonNull(mobileNumber, "mobileNumber must not be null");
                Objects.requireNonNull(residentRegistrationNumber, "residentRegistrationNumber must not be null");
                Objects.requireNonNull(mobileHolderName, "mobileHolderName must not be null");
            }
        }

        public record VirtualAccount(
                String bankName,
                String accountNumber,
                String accountHolderName
        ) {
            public VirtualAccount {
                Objects.requireNonNull(bankName, "bankName must not be null");
                Objects.requireNonNull(accountNumber, "accountNumber must not be null");
                Objects.requireNonNull(accountHolderName, "accountHolderName must not be null");
            }
        }
    }
}
