package com.example.domain.member.api;

import com.example.domain.member.model.Member;

public interface QueryMemberUseCase {

    Member findById(String id);
}
