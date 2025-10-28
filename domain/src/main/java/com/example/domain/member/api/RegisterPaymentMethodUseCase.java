package com.example.domain.member.api;

import com.example.domain.member.model.PaymentMethod;
import com.example.domain.member.api.dto.PaymentMethodCommand;

public interface RegisterPaymentMethodUseCase {

    PaymentMethod execute(PaymentMethodCommand.Register command);
}
