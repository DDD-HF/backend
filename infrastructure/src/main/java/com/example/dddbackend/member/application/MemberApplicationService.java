package com.example.dddbackend.member.application;

import com.example.dddbackend.member.application.mapper.MemberMapper;
import com.example.dddbackend.member.application.mapper.PaymentMethodMapper;
import com.example.dddbackend.member.application.mapper.ProofMapper;
import com.example.domain.member.api.RegisterMemberUseCase;
import com.example.domain.member.api.RegisterPaymentMethodUseCase;
import com.example.domain.member.api.RegisterProofUseCase;
import com.example.domain.member.model.Member;
import com.example.dddbackend.member.presentation.dto.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberApplicationService {

    private final RegisterMemberUseCase registerMemberUseCase;
    private final RegisterPaymentMethodUseCase registerPaymentMethodUseCase;
    private final RegisterProofUseCase registerProofUseCase;

    private final MemberMapper memberMapper;
    private final PaymentMethodMapper paymentMethodMapper;
    private final ProofMapper proofMapper;

    @Transactional
    public Member processRegistration(RegistrationRequest request) {
        var memberCommand = memberMapper.toCommand(request.member());
        var paymentMethodCommand = paymentMethodMapper.toCommand(request.paymentMethod());
        var proofCommand = proofMapper.toCommand(request.proof());

        var member = registerMemberUseCase.execute(memberCommand);
        var paymentMethod = registerPaymentMethodUseCase.execute(paymentMethodCommand);
        var proof = registerProofUseCase.execute(proofCommand);

        return member;
    }

}

