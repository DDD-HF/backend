package com.example.domain.member;

import com.example.domain.common.annotation.DomainService;
import com.example.domain.member.api.DeletePaymentMethodUseCase;
import com.example.domain.member.model.MemberId;
import com.example.domain.member.model.PaymentMethod;
import com.example.domain.member.spi.PaymentMethodRepository;

@DomainService
public class DeletePaymentMethodService implements DeletePaymentMethodUseCase {

    private final PaymentMethodRepository paymentMethodRepository;

    public DeletePaymentMethodService(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @Override
    public void execute(MemberId id) {
        paymentMethodRepository.delete(id);
    }
}
