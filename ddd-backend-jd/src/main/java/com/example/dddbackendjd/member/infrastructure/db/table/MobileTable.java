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
public class MobileTable {

    private String paymentMethodId;
    private String telecomCompany;
    private String mobileNumber;
    private String residentRegistrationNumber;
    private String mobileHolderName;
}
