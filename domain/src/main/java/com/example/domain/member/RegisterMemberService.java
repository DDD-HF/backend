package com.example.domain.member;

import com.example.domain.common.annotation.DomainService;
import com.example.domain.member.api.RegisterMemberUseCase;
import com.example.domain.member.api.dto.MemberCommand;
import com.example.domain.member.model.Member;
import com.example.domain.member.model.MemberId;
import com.example.domain.common.generator.IdGenerator;
import com.example.domain.member.spi.MemberRepository;

@DomainService
public class RegisterMemberService implements RegisterMemberUseCase {

    private final IdGenerator idGenerator;
    private final MemberRepository memberRepository;

    public RegisterMemberService(IdGenerator idGenerator, MemberRepository memberRepository) {
        this.idGenerator = idGenerator;
        this.memberRepository = memberRepository;
    }

    @Override
    public Member execute(MemberCommand.Register command) {
        MemberId memberId = new MemberId(idGenerator.generateId());
        Member newMember = MemberFactory.create(command, memberId);

        return memberRepository.save(newMember);
    }

    private static class MemberFactory {

        private static Member create(MemberCommand.Register command, MemberId memberId) {
            return new Member(
                    memberId,
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
                    command.memo()
            );
        }
    }
}
