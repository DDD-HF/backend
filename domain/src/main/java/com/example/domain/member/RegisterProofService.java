package com.example.domain.member;

import com.example.domain.common.annotation.DomainService;
import com.example.domain.member.api.RegisterProofUseCase;
import com.example.domain.member.api.dto.ProofCommand;
import com.example.domain.member.model.Proof;

@DomainService
public class RegisterProofService implements RegisterProofUseCase {

    @Override
    public Proof execute(ProofCommand.Register command) {
        return null;
    }
}
