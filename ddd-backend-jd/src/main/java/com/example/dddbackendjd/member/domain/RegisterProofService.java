package com.example.dddbackendjd.member.domain;

import com.example.dddbackendjd.common.annotation.DomainService;
import com.example.dddbackendjd.member.domain.api.RegisterProofUseCase;
import com.example.dddbackendjd.member.domain.api.dto.ProofCommand;
import com.example.dddbackendjd.member.domain.model.Proof;

@DomainService
public class RegisterProofService implements RegisterProofUseCase {

    @Override
    public Proof execute(ProofCommand.Register command) {
        return null;
    }
}
