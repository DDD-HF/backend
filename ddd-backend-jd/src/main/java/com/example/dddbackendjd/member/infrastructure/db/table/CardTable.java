package com.example.dddbackendjd.member.infrastructure.db.table;

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
public class CardTable {

    private String paymentMethodId;
    private String cardNumber;
    private String cardHolderName;
    private String cardHolderType;
    private String dateOfBirth;
    private String businessRegistrationNumber;
}
