package com.example.dddbackend.member.application;

import com.example.dddbackend.member.application.mapper.MemberMapper;
import com.example.dddbackend.member.application.mapper.PaymentMethodMapper;
import com.example.dddbackend.member.application.mapper.ProofMapper;
import com.example.dddbackend.member.presentation.dto.RegistrationRequest;
import com.example.domain.member.api.RegisterMemberUseCase;
import com.example.domain.member.api.RegisterPaymentMethodUseCase;
import com.example.domain.member.api.RegisterProofUseCase;
import com.example.domain.member.model.Member;
import com.example.domain.member.model.PaymentMethod;
import com.example.domain.member.model.Proof;
import com.example.domain.member.spi.MemberRepository;
import com.example.domain.member.spi.PaymentMethodRepository;
import com.example.domain.member.spi.ProofRepository;
import com.example.domain.member.spi.dto.MemberView;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberApplicationService {

    private final RegisterMemberUseCase registerMemberUseCase;
    private final RegisterPaymentMethodUseCase registerPaymentMethodUseCase;
    private final RegisterProofUseCase registerProofUseCase;

    private final MemberRepository memberRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final ProofRepository proofRepository;

    private final MemberMapper memberMapper;
    private final PaymentMethodMapper paymentMethodMapper;
    private final ProofMapper proofMapper;

    public MemberApplicationService(RegisterMemberUseCase registerMemberUseCase, RegisterPaymentMethodUseCase registerPaymentMethodUseCase, RegisterProofUseCase registerProofUseCase, MemberRepository memberRepository, PaymentMethodRepository paymentMethodRepository, ProofRepository proofRepository, MemberMapper memberMapper, PaymentMethodMapper paymentMethodMapper, ProofMapper proofMapper) {
        this.registerMemberUseCase = registerMemberUseCase;
        this.registerPaymentMethodUseCase = registerPaymentMethodUseCase;
        this.registerProofUseCase = registerProofUseCase;
        this.memberRepository = memberRepository;
        this.paymentMethodRepository = paymentMethodRepository;
        this.proofRepository = proofRepository;
        this.memberMapper = memberMapper;
        this.paymentMethodMapper = paymentMethodMapper;
        this.proofMapper = proofMapper;
    }

    @Transactional
    public Member processRegistration(RegistrationRequest request) {
        var memberCommand = memberMapper.toCommand(request.member());
        var member = registerMemberUseCase.execute(memberCommand);

        var paymentMethodCommand = paymentMethodMapper.toCommand(request.paymentMethod(), member.memberId());
        var paymentMethod = registerPaymentMethodUseCase.execute(paymentMethodCommand);

        var proofCommand = proofMapper.toCommand(request.proof(), member.memberId());
        var proof = registerProofUseCase.execute(proofCommand);

        return member;
    }

    public List<MemberView> findAllMember() {
        List<Member> members =  memberRepository.findAll();

        List<MemberView> memberViews = new ArrayList<>();

        for (var member : members) {
            List<PaymentMethod> paymentMethodList = paymentMethodRepository.findById(member.memberId());
            List<Proof> proofList = proofRepository.findById(member.memberId());

            MemberView memberView = new MemberView(
                    memberMapper.toMemberDto(member),
                    paymentMethodMapper.toPaymentMethodsDto(paymentMethodList),
                    proofMapper.toProofsDto(proofList));

            memberViews.add(memberView);
        }

        return memberViews;
    }

}

