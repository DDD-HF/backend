package com.example.domain.common.exception;

import com.example.domain.common.constants.DomainErrorCode;

public class BadRequestException extends BaseException {

    public BadRequestException(String message) {
        super(DomainErrorCode.BAD_REQUEST, message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(DomainErrorCode.BAD_REQUEST, message, cause);
    }

    public BadRequestException(DomainErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public BadRequestException(DomainErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }
}
