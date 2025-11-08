package com.example.domain.common.constants;

public enum DomainErrorCode {

    RESOURECE_NOT_FOUND("C001", "리소스를 찾을 수 없습니다."),
    BAD_REQUEST("C002", "잘못된 입력입니다.");

    private final String code;
    private final String detailMessage;

    DomainErrorCode(String code, String detailMessage) {
        this.code = code;
        this.detailMessage = detailMessage;
    }

    public String getCode() {
        return code;
    }

    public String getDetailMessage() {
        return detailMessage;
    }
}
