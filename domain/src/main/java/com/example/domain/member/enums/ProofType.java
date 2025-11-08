package com.example.domain.member.enums;

import com.example.domain.common.constants.DomainErrorCode;
import com.example.domain.common.exception.BadRequestException;

import java.util.logging.Logger;

public enum ProofType {
    현금영수증, 세금계산서;

    private static final Logger log = Logger.getLogger(ProofType.class.getName());

    public static ProofType of(String proofType) {
        try {
            return ProofType.valueOf(proofType);
        } catch (IllegalArgumentException | NullPointerException e) {
            log.severe("Invalid ProofType: " + proofType);
            throw new BadRequestException(DomainErrorCode.BAD_REQUEST.getDetailMessage());
        }
    }
}
