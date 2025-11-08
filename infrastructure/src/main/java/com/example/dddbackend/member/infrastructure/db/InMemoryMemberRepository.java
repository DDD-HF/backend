package com.example.dddbackend.member.infrastructure.db;

import com.example.dddbackend.member.application.mapper.MemberMapper;
import com.example.dddbackend.member.application.mapper.PaymentMethodMapper;
import com.example.dddbackend.member.application.mapper.ProofMapper;
import com.example.domain.member.model.Member;
import com.example.domain.member.model.MemberId;
import com.example.domain.member.model.PaymentMethod;
import com.example.domain.member.model.Proof;
import com.example.domain.member.spi.MemberFinder;
import com.example.domain.member.spi.MemberRepository;
import com.example.domain.member.spi.dto.MemberView;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryMemberRepository implements MemberRepository, MemberFinder {

    private final Map<MemberId, Member> members;
    private final Map<MemberId, List<PaymentMethod>> paymentMethods;
    private final Map<MemberId, List<Proof>> proofs;

    private final MemberMapper memberMapper;
    private final PaymentMethodMapper paymentMethodMapper;
    private final ProofMapper proofMapper;

    public InMemoryMemberRepository(Map<MemberId, Member> members, Map<MemberId, List<PaymentMethod>> paymentMethods, Map<MemberId, List<Proof>> proofs, MemberMapper memberMapper, PaymentMethodMapper paymentMethodMapper, ProofMapper proofMapper) {
        this.members = members;
        this.paymentMethods = paymentMethods;
        this.proofs = proofs;
        this.memberMapper = memberMapper;
        this.paymentMethodMapper = paymentMethodMapper;
        this.proofMapper = proofMapper;
    }

    @Override
    public Member save(Member member) {
        members.computeIfAbsent(member.memberId(), (key) -> member);
        return member;
    }

    @Override
    public List<MemberView> findAll() {
        List<MemberView> memberViews = new ArrayList<>();

        for (var member : members.values()) {
            List<PaymentMethod> paymentMethodList = paymentMethods.getOrDefault(member.memberId(), List.of());
            List<Proof> proofList = proofs.getOrDefault(member.memberId(), List.of());

            MemberView memberView = new MemberView(
                    memberMapper.toMemberDto(member),
                    paymentMethodMapper.toPaymentMethodsDto(paymentMethodList),
                    proofMapper.toProofsDto(proofList));

            memberViews.add(memberView);
        }

        return memberViews;
    }
}
