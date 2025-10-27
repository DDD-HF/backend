package com.example.dddbackendjd.member.infrastructure.db;

import com.example.dddbackendjd.member.domain.model.Member;
import com.example.dddbackendjd.member.domain.model.MemberId;
import com.example.dddbackendjd.member.domain.spi.MemberRepository;
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
