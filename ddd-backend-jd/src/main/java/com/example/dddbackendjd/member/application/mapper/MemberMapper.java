package com.example.dddbackendjd.member.application.mapper;

import com.example.dddbackendjd.common.configuration.MapStructConfig;
import com.example.dddbackendjd.member.domain.Member;
import com.example.dddbackendjd.member.domain.api.dto.MemberCommand;
import com.example.dddbackendjd.member.domain.api.dto.PaymentMethodCommand;
import com.example.dddbackendjd.member.presentation.model.RegisterMemberRequest;
import com.example.dddbackendjd.member.presentation.model.RegisterPaymentMethodRequest;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfig.class)
public interface MemberMapper {

    MemberCommand.Register toCommand(RegisterMemberRequest request);

//    Member toDomain(MemberCommand.Register register);
}
