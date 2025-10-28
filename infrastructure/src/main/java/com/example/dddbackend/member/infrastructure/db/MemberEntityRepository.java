package com.example.dddbackend.member.infrastructure.db;

import com.example.domain.member.model.Member;
import com.example.domain.member.model.MemberId;
import com.example.domain.member.spi.MemberRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MemberEntityRepository implements MemberRepository {

    @Override
    public Member findById(MemberId id) {
        return null;
    }

    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public Member update(Member member) {
        return null;
    }

    @Override
    public void delete(Member member) {

    }
}
