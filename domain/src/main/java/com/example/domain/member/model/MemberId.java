package com.example.domain.member.model;

import java.util.Objects;

public record MemberId(
        String id
) {

    public MemberId {
        Objects.requireNonNull(id, "id must not be null");
    }
}
