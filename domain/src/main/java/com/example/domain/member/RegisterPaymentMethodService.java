package com.example.domain.member;

import com.example.domain.common.annotation.DomainService;
import com.example.domain.member.api.RegisterPaymentMethodUseCase;
import com.example.domain.member.api.dto.PaymentMethodCommand;
import com.example.domain.member.model.PaymentMethod;

@DomainService
public class RegisterPaymentMethodService implements RegisterPaymentMethodUseCase {

    @Override
    public PaymentMethod execute(PaymentMethodCommand.Register command) {
        return null;
    }
}
