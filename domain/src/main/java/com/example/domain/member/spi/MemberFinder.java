package com.example.domain.member.spi;

import com.example.domain.member.model.MemberId;
import com.example.domain.member.spi.dto.MemberView;

import java.util.List;

public interface MemberFinder {

    List<MemberView> findAll();
}
