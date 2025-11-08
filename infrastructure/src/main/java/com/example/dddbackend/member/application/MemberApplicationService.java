package com.example.dddbackend.member.application;

import com.example.dddbackend.member.application.mapper.MemberMapper;
import com.example.dddbackend.member.application.mapper.PaymentMethodMapper;
import com.example.dddbackend.member.application.mapper.ProofMapper;
import com.example.domain.member.api.RegisterMemberUseCase;
import com.example.domain.member.api.RegisterPaymentMethodUseCase;
import com.example.domain.member.api.RegisterProofUseCase;
import com.example.domain.member.model.Member;
import com.example.dddbackend.member.presentation.dto.RegistrationRequest;
import com.example.domain.member.spi.MemberFinder;
import com.example.domain.member.spi.dto.MemberView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberApplicationService {

    private final RegisterMemberUseCase registerMemberUseCase;
    private final RegisterPaymentMethodUseCase registerPaymentMethodUseCase;
    private final RegisterProofUseCase registerProofUseCase;

    private final MemberFinder memberFinder;

    private final MemberMapper memberMapper;
    private final PaymentMethodMapper paymentMethodMapper;
    private final ProofMapper proofMapper;

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
        return memberFinder.findAll();
    }

}

