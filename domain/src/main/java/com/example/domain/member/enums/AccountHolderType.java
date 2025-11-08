package com.example.domain.member.enums;

import com.example.domain.common.constants.DomainErrorCode;
import com.example.domain.common.exception.BadRequestException;

import java.util.logging.Logger;

public enum AccountHolderType {
    개인, 법인;

    private static final Logger log = Logger.getLogger(AccountHolderType.class.getName());

    public static AccountHolderType of(String accountHolderType) {
        try {
            return AccountHolderType.valueOf(accountHolderType);
        } catch (IllegalArgumentException | NullPointerException e) {
            log.severe("Invalid AccountHolderType: " + accountHolderType);
            throw new BadRequestException(DomainErrorCode.BAD_REQUEST.getDetailMessage());
        }
    }
}
