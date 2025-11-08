package com.example.domain.common.exception;

import com.example.domain.common.constants.DomainErrorCode;

import java.util.Objects;

public abstract class BaseException extends RuntimeException {

    private final DomainErrorCode errorCode;

    public BaseException(DomainErrorCode errorCode, String message) {
        super(message);

        Objects.requireNonNull(errorCode);
        this.errorCode = errorCode;
    }

    public BaseException(DomainErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);

        Objects.requireNonNull(errorCode);
        this.errorCode = errorCode;
    }

    public DomainErrorCode getErrorCode() {
        return errorCode;
    }
}
