package com.example.dddbackend.common.configuration;

import com.example.dddbackend.common.utils.EnumUtil;
import com.example.domain.member.enums.AccountHolderType;
import com.example.domain.member.enums.CardHolderType;
import com.example.domain.member.enums.PaymentMethodType;
import com.example.domain.member.enums.ProofType;
import com.example.domain.member.enums.TaxType;
import org.springframework.stereotype.Component;

@Component
public class EnumConverter {

    public AccountHolderType toAccountHolderType(String accountHolderType) {
        return EnumUtil.of(AccountHolderType.class, accountHolderType);
    }

    public CardHolderType toCardHolderType(String cardHolderType) {
        return EnumUtil.of(CardHolderType.class, cardHolderType);
    }

    public PaymentMethodType toPaymentMethodType(String paymentMethodType) {
        return EnumUtil.of(PaymentMethodType.class, paymentMethodType);
    }

    public ProofType toProofType(String proofType) {
        return EnumUtil.of(ProofType.class, proofType);
    }

    public TaxType toTaxType(String taxType) {
        return EnumUtil.of(TaxType.class, taxType);
    }


}
