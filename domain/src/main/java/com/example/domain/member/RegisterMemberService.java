package com.example.domain.member;

import com.example.domain.common.annotation.DomainService;
import com.example.domain.member.api.RegisterMemberUseCase;
import com.example.domain.member.api.dto.MemberCommand;
import com.example.domain.member.model.Member;
import com.example.domain.member.spi.MemberRepository;

@DomainService
public class RegisterMemberService implements RegisterMemberUseCase {

    private final MemberRepository memberRepository;

    public RegisterMemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member execute(MemberCommand.Register command) {
        Member newMember = command.toDomain();
        return memberRepository.save(newMember);
    }
}
