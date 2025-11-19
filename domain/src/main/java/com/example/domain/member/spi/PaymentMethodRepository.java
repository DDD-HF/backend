package com.example.domain.member.spi;

import com.example.domain.member.model.MemberId;
import com.example.domain.member.model.PaymentMethod;

import java.util.List;

public interface PaymentMethodRepository {

    PaymentMethod save(PaymentMethod paymentMethod);

    List<PaymentMethod> findById(MemberId id);

}
