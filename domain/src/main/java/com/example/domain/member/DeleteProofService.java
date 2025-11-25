package com.example.domain.member;

import com.example.domain.common.annotation.DomainService;
import com.example.domain.member.api.DeleteProofUseCase;
import com.example.domain.member.model.MemberId;
import com.example.domain.member.model.Proof;
import com.example.domain.member.spi.ProofRepository;

@DomainService
public class DeleteProofService implements DeleteProofUseCase {

    private final ProofRepository proofRepository;

    public DeleteProofService(ProofRepository proofRepository) {
        this.proofRepository = proofRepository;
    }

    @Override
    public void execute(MemberId id) {
        proofRepository.delete(id);
    }
}
