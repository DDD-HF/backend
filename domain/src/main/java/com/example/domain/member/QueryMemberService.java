package com.example.domain.member;

import com.example.domain.common.annotation.DomainService;
import com.example.domain.member.api.QueryMemberUseCase;
import com.example.domain.member.model.Member;
import com.example.domain.member.model.MemberId;
import com.example.domain.member.spi.MemberRepository;

@DomainService
public class QueryMemberService implements QueryMemberUseCase {

    private final MemberRepository memberRepository;

    public QueryMemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member findById(String id) {
        return memberRepository.findById(new MemberId(id));
    }
}
