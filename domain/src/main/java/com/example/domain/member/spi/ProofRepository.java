package com.example.domain.member.spi;

import com.example.domain.member.model.MemberId;
import com.example.domain.member.model.Proof;

import java.util.List;

public interface ProofRepository {

    Proof save(Proof proof);

    List<Proof> findById(MemberId id);

}
