package com.example.dddbackend.member.presentation.controller;

import com.example.dddbackend.member.application.MemberApplicationService;
import com.example.dddbackend.member.presentation.dto.RegistrationRequest;
import com.example.domain.member.spi.dto.MemberView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberApplicationService memberApplicationService;

    public MemberController(MemberApplicationService memberApplicationService) {
        this.memberApplicationService = memberApplicationService;
    }

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

    @GetMapping(value = "")
    public List<MemberView> allMember() {
        return memberApplicationService.findAllMember();
    }
    
    //todd memberview가 아닌 response로 변환해서 보여주기
}
