package com.example.dddbackendjd.member.domain.api;

import com.example.dddbackendjd.member.domain.model.Member;
import com.example.dddbackendjd.member.domain.api.dto.MemberCommand;

public interface RegisterMemberUseCase {

    Member execute(MemberCommand.Register command);
}
