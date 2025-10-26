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
public class MemberTable {

    private String memberId;
    private String status;
    private String name;
    private String memberNumber;
    private String email;
    private String zipCode;
    private String address;
    private String detailedAddress;
    private String mobileNumber;
    private String landlineNumber;
    private String registrationDate;
    private boolean isSmsSendingAllowed;
    private String memo;
}
