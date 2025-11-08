package com.example.domain.member.spi;

import com.example.domain.member.model.PaymentMethod;

public interface PaymentMethodRepository {

    PaymentMethod save(PaymentMethod paymentMethod);

}
