package com.example.dddbackend.member.application.mapper;

import com.example.dddbackend.common.configuration.MapStructConfig;
import com.example.domain.member.api.dto.PaymentMethodCommand;
import com.example.dddbackend.member.presentation.dto.RegisterPaymentMethodRequest;
import com.example.domain.member.model.Card;
import com.example.domain.member.model.Cms;
import com.example.domain.member.model.MemberId;
import com.example.domain.member.model.Mobile;
import com.example.domain.member.model.PayerPayment;
import com.example.domain.member.model.PaymentMethod;
import com.example.domain.member.model.Rcms;
import com.example.domain.member.model.VirtualAccount;
import com.example.domain.member.spi.dto.MemberView;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper(config = MapStructConfig.class)
public interface PaymentMethodMapper {

    PaymentMethodCommand.Register toCommand(RegisterPaymentMethodRequest request, MemberId memberId);

    PaymentMethodCommand.Register.Cms toCommand(RegisterPaymentMethodRequest.Cms cms);

    PaymentMethodCommand.Register.Rcms toCommand(RegisterPaymentMethodRequest.Rcms rcms);

    PaymentMethodCommand.Register.Card toCommand(RegisterPaymentMethodRequest.Card card);

    PaymentMethodCommand.Register.Mobile toCommand(RegisterPaymentMethodRequest.Mobile mobile);

    PaymentMethodCommand.Register.VirtualAccount toCommand(RegisterPaymentMethodRequest.VirtualAccount virtualAccount);

    PaymentMethodCommand.Register.PayerPayment toCommand(RegisterPaymentMethodRequest.PayerPayment payerPayment);

    @Mapping(source = "paymentMethodId.id", target = "paymentMethodId")
    @Mapping(source = "memberId.id", target = "memberId")
    MemberView.Cms toCmsDto(Cms cms);
    @Mapping(source = "paymentMethodId.id", target = "paymentMethodId")
    @Mapping(source = "memberId.id", target = "memberId")
    MemberView.Rcms toRcmsDto(Rcms card);
    @Mapping(source = "paymentMethodId.id", target = "paymentMethodId")
    @Mapping(source = "memberId.id", target = "memberId")
    MemberView.Card toCardDto(Card card);
    @Mapping(source = "paymentMethodId.id", target = "paymentMethodId")
    @Mapping(source = "memberId.id", target = "memberId")
    MemberView.Mobile toMobileDto(Mobile card);
    @Mapping(source = "paymentMethodId.id", target = "paymentMethodId")
    @Mapping(source = "memberId.id", target = "memberId")
    MemberView.VirtualAccount toVirtualAccountDto(VirtualAccount card);
    @Mapping(source = "paymentMethodId.id", target = "paymentMethodId")
    @Mapping(source = "memberId.id", target = "memberId")
    MemberView.PayerPayment toPayerPaymentDto(PayerPayment card);

    default MemberView.PaymentMethod toPaymentMethodsDto(List<PaymentMethod> paymentMethodList) {
        var cmsList = new ArrayList<MemberView.Cms>();
        var rcmsList = new ArrayList<MemberView.Rcms>();
        var cardList = new ArrayList<MemberView.Card>();
        var mobileList = new ArrayList<MemberView.Mobile>();
        var virtualAccountList = new ArrayList<MemberView.VirtualAccount>();
        var payerPaymentList = new ArrayList<MemberView.PayerPayment>();

        for (PaymentMethod paymentMethod : paymentMethodList) {
            switch (paymentMethod) {
                case Cms cms -> cmsList.add(toCmsDto(cms));
                case Rcms rcms -> rcmsList.add(toRcmsDto(rcms));
                case Card card -> cardList.add(toCardDto(card));
                case Mobile mobile -> mobileList.add(toMobileDto(mobile));
                case VirtualAccount va -> virtualAccountList.add(toVirtualAccountDto(va));
                case PayerPayment pp -> payerPaymentList.add(toPayerPaymentDto(pp));
            }
        }

        return new MemberView.PaymentMethod(
                cmsList, rcmsList, cardList, mobileList, virtualAccountList, payerPaymentList
        );
    }
}
