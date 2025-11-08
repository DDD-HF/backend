package com.example.dddbackend.member.infrastructure.db.table;

import com.example.domain.member.model.Member;
import com.example.domain.member.model.MemberId;
import com.example.domain.member.model.PaymentMethod;
import com.example.domain.member.model.Proof;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class InMemoryStoreConfiguration {

    @Bean
    public Map<MemberId, Member> members() {
        return new ConcurrentHashMap<>();
    }

    @Bean
    public Map<MemberId, List<PaymentMethod>> paymentMethods() {
        return new ConcurrentHashMap<>();
    }

    @Bean
    public Map<MemberId, List<Proof>> proofs() {
        return new ConcurrentHashMap<>();
    }
}
