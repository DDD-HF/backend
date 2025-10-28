package com.example.dddbackend.member.infrastructure.db.table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class PayerPaymentTable {

    private boolean isCardEnabled;
    private boolean isAccountEnabled;
    private boolean isSimplePaymentEnabled;
}
