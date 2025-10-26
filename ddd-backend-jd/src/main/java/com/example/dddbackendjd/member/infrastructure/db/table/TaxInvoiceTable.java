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
public class TaxInvoiceTable {

    /**
     * 증빙 id
     */
    private String proofId;
    /**
     * 회원 유형
     */
    private String memberType;
    /**
     * 과세 유형
     */
    private String taxType;
    /**
     * 등록 번호
     */
    private String registrationNumber;
    /**
     * 상호
     */
    private String tradeName;
    /**
     * 대표자명
     */
    private String representativeName;
    /**
     * 품목명
     */
    private String itemName;
    /**
     * 발급 유형
     */
    private String issuanceType;
    /**
     * 발급 방식
     */
    private String issuanceMethod;
}
