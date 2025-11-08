package com.example.domain.member.enums;

import com.example.domain.common.constants.DomainErrorCode;
import com.example.domain.common.exception.BadRequestException;

import java.util.EnumSet;

public sealed interface Type permits TaxType {

    static <E extends Enum<E> & Type> E of(Class<E> enumType, String name) {
        return of(enumType, name, DomainErrorCode.BAD_REQUEST.getDetailMessage());
    }

    static <E extends Enum<E> & Type> E of(Class<E> enumType, String name, String message) {
        return EnumSet.allOf(enumType).stream()
                .filter(e -> e.name().equals(name))
                .findAny()
                .orElseThrow(() -> new BadRequestException(message));
    }
}
