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
public class CmsTable {

    private String paymentMethodId;
    private String bankName;
    private String accountNumber;
    private String accountHolderName;
    private String accountHolderType;
    private String dateOfBirth;
    private String businessRegistrationNumber;
    private String consentInformation;
}
