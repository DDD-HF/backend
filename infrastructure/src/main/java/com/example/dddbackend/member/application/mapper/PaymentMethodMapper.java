package com.example.dddbackend.member.application.mapper;

import com.example.dddbackend.common.configuration.MapStructConfig;
import com.example.domain.member.api.dto.PaymentMethodCommand;
import com.example.dddbackend.member.presentation.dto.RegisterPaymentMethodRequest;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfig.class)
public interface PaymentMethodMapper {

    PaymentMethodCommand.Register toCommand(RegisterPaymentMethodRequest request);

    PaymentMethodCommand.Register.Cms toCommand(RegisterPaymentMethodRequest.Cms cms);

    PaymentMethodCommand.Register.Rcms toCommand(RegisterPaymentMethodRequest.Rcms rcms);

    PaymentMethodCommand.Register.Card toCommand(RegisterPaymentMethodRequest.Card card);

    PaymentMethodCommand.Register.Mobile toCommand(RegisterPaymentMethodRequest.Mobile mobile);

    PaymentMethodCommand.Register.VirtualAccount toCommand(RegisterPaymentMethodRequest.VirtualAccount virtualAccount);
}
