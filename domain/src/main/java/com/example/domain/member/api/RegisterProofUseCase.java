package com.example.domain.member.api;

import com.example.domain.member.model.Proof;
import com.example.domain.member.api.dto.ProofCommand;

public interface RegisterProofUseCase {

    Proof execute(ProofCommand.Register command);
}
