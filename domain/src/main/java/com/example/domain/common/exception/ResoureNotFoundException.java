package com.example.domain.common.exception;

import com.example.domain.common.constants.DomainErrorCode;

public class ResoureNotFoundException extends BaseException {

    public ResoureNotFoundException(String message) {
        super(DomainErrorCode.RESOURECE_NOT_FOUND, message);
    }

    public ResoureNotFoundException(DomainErrorCode errorCode, String message) {
        super(errorCode, message);
    }
}
