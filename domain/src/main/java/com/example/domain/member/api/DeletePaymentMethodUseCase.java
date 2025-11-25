package com.example.domain.member.api;

import com.example.domain.member.model.MemberId;
import com.example.domain.member.model.PaymentMethod;

public interface DeletePaymentMethodUseCase {

    void execute(MemberId memberId);
}
