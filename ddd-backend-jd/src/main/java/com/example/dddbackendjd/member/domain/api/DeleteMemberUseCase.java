package com.example.dddbackendjd.member.domain.api;

import com.example.dddbackendjd.member.domain.api.dto.MemberCommand;

public interface DeleteMemberUseCase {
    void execute(MemberCommand.Delete command);
}
