package com.example.dddbackendjd.member.application;

import com.example.dddbackendjd.member.application.mapper.MemberMapper;
import com.example.dddbackendjd.member.application.mapper.PaymentMethodMapper;
import com.example.dddbackendjd.member.application.mapper.ProofMapper;
import com.example.dddbackendjd.member.domain.Member;
import com.example.dddbackendjd.member.domain.api.RegisterMemberUseCase;
import com.example.dddbackendjd.member.domain.api.RegisterPaymentMethodUseCase;
import com.example.dddbackendjd.member.domain.api.RegisterProofUseCase;
import com.example.dddbackendjd.member.presentation.model.RegistrationRequest;
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

