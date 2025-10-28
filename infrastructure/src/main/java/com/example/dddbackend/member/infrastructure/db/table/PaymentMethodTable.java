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
public class PaymentMethodTable {

    private String paymentMethodId;
    private String memberId;
    private String paymentMethodType;
    private boolean isRecurringPaymentAgreed;
}
