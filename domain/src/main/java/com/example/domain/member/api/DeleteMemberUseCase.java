package com.example.domain.member.api;

import com.example.domain.member.api.dto.MemberCommand;

public interface DeleteMemberUseCase {
    void execute(MemberCommand.Delete command);
}
