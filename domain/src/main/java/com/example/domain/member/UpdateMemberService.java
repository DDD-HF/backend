package com.example.domain.member;

import com.example.domain.common.annotation.DomainService;
import com.example.domain.member.api.UpdateMemberUseCase;
import com.example.domain.member.api.dto.MemberCommand;
import com.example.domain.member.model.Member;
import com.example.domain.member.spi.MemberRepository;

@DomainService
public class UpdateMemberService implements UpdateMemberUseCase {

    private final MemberRepository memberRepository;

    public UpdateMemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member execute(MemberCommand.Update command) {
        Member member = memberRepository.findById(command.toId());
        if (member == null) {
            throw new IllegalArgumentException("Member not found");
        }

        Member updatedMember = new Member(
                member.memberId(),
                command.status(),
                command.name(),
                command.memberNumber(),
                command.email(),
                command.zipCode(),
                command.address(),
                command.detailedAddress(),
                command.mobileNumber(),
                command.landlineNumber(),
                command.registrationDate(),
                command.isSmsSendingAllowed(),
                command.memo());

        return memberRepository.save(updatedMember);
    }
}
