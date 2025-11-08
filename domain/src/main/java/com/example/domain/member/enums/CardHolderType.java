package com.example.domain.member.enums;

import com.example.domain.common.constants.DomainErrorCode;
import com.example.domain.common.exception.BadRequestException;

import java.util.logging.Logger;

public enum CardHolderType {
    개인, 법인;

    private static final Logger log = Logger.getLogger(CardHolderType.class.getName());

    public static CardHolderType of(String cardHolderType) {
        try {
            return CardHolderType.valueOf(cardHolderType);
        } catch (IllegalArgumentException | NullPointerException e) {
            log.severe("Invalid CardHolderType: " + cardHolderType);
            throw new BadRequestException(DomainErrorCode.BAD_REQUEST.getDetailMessage());
        }
    }
}
