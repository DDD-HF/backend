package com.example.dddbackendjd.member.domain;

import com.example.dddbackendjd.common.annotation.DomainService;
import com.example.dddbackendjd.member.domain.api.RegisterPaymentMethodUseCase;
import com.example.dddbackendjd.member.domain.api.dto.PaymentMethodCommand;
import com.example.dddbackendjd.member.domain.model.PaymentMethod;

@DomainService
public class RegisterPaymentMethodService implements RegisterPaymentMethodUseCase {

    @Override
    public PaymentMethod execute(PaymentMethodCommand.Register command) {
        return null;
    }
}
