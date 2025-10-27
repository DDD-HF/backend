package com.example.dddbackendjd.member.domain.model;

import org.springframework.util.Assert;

public record MemberId(
        String id
) {

    public MemberId {
        Assert.notNull(id, "id must not be null");
    }
}
