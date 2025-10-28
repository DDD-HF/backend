package com.example.dddbackend.member.application.mapper;

import com.example.dddbackend.common.configuration.MapStructConfig;
import com.example.domain.member.api.dto.MemberCommand;
import com.example.dddbackend.member.presentation.dto.RegisterMemberRequest;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfig.class)
public interface MemberMapper {

    MemberCommand.Register toCommand(RegisterMemberRequest request);

//    Member toDomain(MemberCommand.Register register);
}
