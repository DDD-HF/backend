package com.example.domain.member.api;

import com.example.domain.member.model.MemberId;

public interface DeleteProofUseCase {

    void execute(MemberId memberId);
}
