package com.example.dddbackendjd.member.domain.spi;

import com.example.dddbackendjd.member.domain.model.Member;
import com.example.dddbackendjd.member.domain.model.MemberId;

public interface MemberRepository {

    Member findById(MemberId id);

    Member save(Member member);

    Member update(Member member);

    void delete(Member member);

}
