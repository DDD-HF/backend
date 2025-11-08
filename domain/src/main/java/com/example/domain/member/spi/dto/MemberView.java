package com.example.domain.member.spi.dto;

import com.example.domain.member.enums.AccountHolderType;
import com.example.domain.member.enums.CardHolderType;
import com.example.domain.member.enums.TaxType;
import com.example.domain.member.model.MemberId;
import com.example.domain.member.model.PaymentMethodId;
import com.example.domain.member.model.ProofId;

import java.util.List;

public record MemberView(
        Member member,
        PaymentMethod paymentMethods,
        Proof proofs
) {

    public record Member(
            Long memberId,
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

    public record PaymentMethod(
            List<Cms> cms,
            List<Rcms> rcms,
            List<Card> card,
            List<Mobile> mobile,
            List<VirtualAccount> virtualAccount,
            List<PayerPayment> payerPayment
    ) {
    }

    public record Cms(
            Long paymentMethodId,
            Long memberId,
            boolean isRecurringPaymentAgreed,
            String bankName,
            String accountNumber,
            String accountHolderName,
            AccountHolderType accountHolderType,
            String dateOfBirth,
            String businessRegistrationNumber,
            String consentInformation
    ) {
    }

    public record Rcms(
            Long paymentMethodId,
            Long memberId,
            boolean isRecurringPaymentAgreed,
            String bankName,
            String accountNumber,
            String accountHolderName,
            AccountHolderType accountHolderType,
            String dateOfBirth,
            String businessRegistrationNumber,
            String consentInformation
    ) {
    }

    public record Card(
            Long paymentMethodId,
            Long memberId,
            boolean isRecurringPaymentAgreed,
            String cardNumber,
            String cardHolderName,
            CardHolderType cardHolderType,
            String dateOfBirth,
            String businessRegistrationNumber
    ) {
    }

    public record Mobile(
            Long paymentMethodId,
            Long memberId,
            boolean isRecurringPaymentAgreed,
            String telecomCompany,
            String mobileNumber,
            String residentRegistrationNumber,
            String mobileHolderName
    ) {
    }

    public record VirtualAccount(
            Long paymentMethodId,
            Long memberId,
            boolean isRecurringPaymentAgreed,
            String bankName,
            String accountNumber,
            String accountHolderName
    ) {
    }

    public record PayerPayment(
            Long paymentMethodId,
            Long memberId,
            boolean isRecurringPaymentAgreed,
            boolean isCardEnabled,
            boolean isAccountEnabled,
            boolean isSimplePaymentEnabled
    ) {
    }

    public record Proof(
            List<CashReceipt> cashReceipt,
            List<TaxInvoice> taxInvoice
    ) {
    }

    public record CashReceipt(
            Long proofId,
            Long memberId,
            boolean isAutomatedIssuance,
            String cashReceiptInformation
    ) {
    }

    public record TaxInvoice(
            Long proofId,
            Long memberId,
            boolean isAutomatedIssuance,
            String memberType,
            TaxType taxType,
            String registrationNumber,
            String tradeName,
            String representativeName,
            String itemName,
            String issuanceType
    ) {
    }
}
