package com.example.dddbackendjd.member.presentation.dto;

public record RegisterPaymentMethodRequest(
        String paymentMethodType,
        Cms cms,
        Rcms rcms,
        Card card,
        Mobile mobile,
        VirtualAccount virtualAccount
) {

    public record Cms(
            String bankName,
            String accountNumber,
            String accountHolderName,
            String accountHolderType,
            String dateOfBirth,
            String businessRegistrationNumber,
            String consentInformation
    ) {
    }

    public record Rcms(
            String bankName,
            String accountNumber,
            String accountHolderName,
            String accountHolderType,
            String dateOfBirth,
            String businessRegistrationNumber,
            String consentInformation
    ) {
    }

    public record Card(
            String cardNumber,
            String cardHolderName,
            String cardHolderType,
            String dateOfBirth,
            String businessRegistrationNumber
    ) {
    }

    public record Mobile(
            String telecomCompany,
            String mobileNumber,
            String residentRegistrationNumber,
            String mobileHolderName
    ) {
    }

    public record VirtualAccount(
            String bankName,
            String accountNumber,
            String accountHolderName
    ) {
    }
}
