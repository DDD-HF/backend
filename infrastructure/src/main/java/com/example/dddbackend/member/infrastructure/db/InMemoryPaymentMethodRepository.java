package com.example.dddbackend.member.infrastructure.db;

import com.example.domain.member.model.MemberId;
import com.example.domain.member.model.PaymentMethod;
import com.example.domain.member.model.PaymentMethodId;
import com.example.domain.member.spi.PaymentMethodRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryPaymentMethodRepository implements PaymentMethodRepository {

    private final Map<MemberId, List<PaymentMethod>> paymentMethods;

    public InMemoryPaymentMethodRepository(Map<MemberId, List<PaymentMethod>> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    @Override
    public PaymentMethod save(PaymentMethod paymentMethod) {
        List<PaymentMethod> paymentMethodList = paymentMethods.get(paymentMethod.paymentMethodId());
        if (paymentMethodList == null) {
            paymentMethodList = new ArrayList<>();
        }
        paymentMethodList.add(paymentMethod);
        paymentMethods.put(paymentMethod.memberId(), paymentMethodList);

        return paymentMethod;
    }

    @Override
    public List<PaymentMethod> findById(MemberId id) {
        return paymentMethods.getOrDefault(id, List.of());
    }

    @Override
    public void delete(MemberId id) {
        paymentMethods.remove(id);
    }
}
