package com.example.dddbackendjd.test.application;

import com.example.dddbackendjd.member.domain.api.RegisterMemberUseCase;
import com.example.dddbackendjd.test.domain.api.TestUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestApplicationService {

    private final RegisterMemberUseCase registerMemberUseCase;
    private final TestUseCase testUseCase;
}
