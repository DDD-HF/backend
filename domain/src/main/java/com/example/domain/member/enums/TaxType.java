package com.example.domain.member.enums;

import java.util.logging.Logger;

public enum TaxType implements Type {
    과세, 면세;

    private static final Logger log = Logger.getLogger(TaxType.class.getName());

}
