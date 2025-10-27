package com.example.dddbackendjd.member.application.mapper;

import com.example.dddbackendjd.common.configuration.MapStructConfig;
import com.example.dddbackendjd.member.domain.api.dto.MemberCommand;
import com.example.dddbackendjd.member.presentation.dto.RegisterMemberRequest;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfig.class)
public interface MemberMapper {

    MemberCommand.Register toCommand(RegisterMemberRequest request);

//    Member toDomain(MemberCommand.Register register);
}
