package com.example.domain.member.spi;

import com.example.domain.member.model.Member;
import com.example.domain.member.model.MemberId;

import java.util.List;

public interface MemberRepository {

//    Member findById(MemberId id);

    Member save(Member member);

    List<Member> findAll();

}
