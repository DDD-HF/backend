package com.example.domain.member.enums;

import com.example.domain.common.constants.DomainErrorCode;
import com.example.domain.common.exception.BadRequestException;

import java.util.logging.Logger;

public enum PaymentMethodType {
    CMS, 실시간CMS, 카드, 휴대전화, 가상계좌, 납부자결제;

    private static final Logger log = Logger.getLogger(PaymentMethodType.class.getName());

    public static PaymentMethodType of(String paymentMethodType) {
        try {
            return PaymentMethodType.valueOf(paymentMethodType);
        } catch (IllegalArgumentException | NullPointerException e) {
            log.severe("Invalid PaymentMethodType: " + paymentMethodType);
            throw new BadRequestException(DomainErrorCode.BAD_REQUEST.getDetailMessage());
        }
    }
}
