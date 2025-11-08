package com.example.dddbackend.member.application.mapper;

import com.example.dddbackend.common.configuration.MapStructConfig;
import com.example.domain.member.api.dto.MemberCommand;
import com.example.dddbackend.member.presentation.dto.RegisterMemberRequest;
import com.example.domain.member.model.Member;
import com.example.domain.member.spi.dto.MemberView;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class)
public interface MemberMapper {

    MemberCommand.Register toCommand(RegisterMemberRequest request);

//    Member toDomain(MemberCommand.Register register);

    @Mapping(source = "memberId.id", target = "memberId")
    MemberView.Member toMemberDto(Member member);
}
