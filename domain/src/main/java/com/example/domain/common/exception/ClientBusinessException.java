package com.example.domain.common.exception;

import com.example.domain.common.constants.DomainErrorCode;

public class ClientBusinessException extends BaseException {

    public ClientBusinessException(DomainErrorCode errorCode, String message) {
        super(errorCode, message);
    }
}
