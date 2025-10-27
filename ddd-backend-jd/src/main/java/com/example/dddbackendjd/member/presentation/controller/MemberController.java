package com.example.dddbackendjd.member.presentation.controller;

import com.example.dddbackendjd.member.application.MemberApplicationService;
import com.example.dddbackendjd.member.presentation.dto.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberApplicationService memberApplicationService;

    @PostMapping("/registration")
    public ResponseEntity<Void> processRegistration(@RequestBody RegistrationRequest request) {
        var member = memberApplicationService.processRegistration(request);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentServletMapping()
                .path("/api/v1/members/{id}")
                .buildAndExpand(member.memberId().id())
                .toUri();

        return ResponseEntity.created(uri).build();
    }
}
