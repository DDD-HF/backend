package com.example.dddbackend.common.utils;

import com.example.domain.common.constants.DomainErrorCode;
import com.example.domain.common.exception.BadRequestException;

public final class EnumUtil {

    private EnumUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static <E extends Enum<E>> E of(Class<E> enumClass, String name) {
        return of(enumClass, name, DomainErrorCode.BAD_REQUEST.getDetailMessage());
    }

    public static <E extends Enum<E>> E of(Class<E> enumClass, String name, String message) {
        try {
            return Enum.valueOf(enumClass, name);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new BadRequestException(message, e);
        }
    }

}
