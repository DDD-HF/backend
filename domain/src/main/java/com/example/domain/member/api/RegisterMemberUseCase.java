package com.example.domain.member.api;

import com.example.domain.member.model.Member;
import com.example.domain.member.api.dto.MemberCommand;

public interface RegisterMemberUseCase {

    Member execute(MemberCommand.Register command);
}
