package com.example.domain.member;

import com.example.domain.common.annotation.DomainService;
import com.example.domain.member.api.DeleteMemberUseCase;
import com.example.domain.member.api.dto.MemberCommand;
import com.example.domain.member.model.Member;
import com.example.domain.member.spi.MemberRepository;

@DomainService
public class DeleteMemberService implements DeleteMemberUseCase {

    private final MemberRepository memberRepository;

    public DeleteMemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void execute(MemberCommand.Delete command) {
        Member member = memberRepository.findById(command.toId());
        memberRepository.delete(member);
    }
}
