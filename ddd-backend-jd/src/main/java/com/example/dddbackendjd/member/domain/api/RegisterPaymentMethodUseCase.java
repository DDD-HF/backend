package com.example.dddbackendjd.member.domain.api;

import com.example.dddbackendjd.member.domain.PaymentMethod;
import com.example.dddbackendjd.member.domain.api.dto.PaymentMethodCommand;

public interface RegisterPaymentMethodUseCase {

    PaymentMethod execute(PaymentMethodCommand.Register command);
}
