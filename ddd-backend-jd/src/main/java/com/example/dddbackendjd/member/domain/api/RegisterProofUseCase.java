package com.example.dddbackendjd.member.domain.api;

import com.example.dddbackendjd.member.domain.model.Proof;
import com.example.dddbackendjd.member.domain.api.dto.ProofCommand;

public interface RegisterProofUseCase {

    Proof execute(ProofCommand.Register command);
}
