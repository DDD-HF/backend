package com.example.dddbackend.member.presentation.controller;

import com.example.dddbackend.member.application.MemberApplicationService;
import com.example.dddbackend.member.presentation.dto.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
@Profile("mock")
public class MemberMockController {

    private final MemberApplicationService memberApplicationService;

    @PostMapping("/registration")
    public ResponseEntity<Void> processRegistration(@RequestBody RegistrationRequest request) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentServletMapping()
                .path("/api/v1/members/{id}")
                .buildAndExpand("1")
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public String allMember() {
        String jsonString = """
                [{
                  "member": {
                    "memberId": 15123412,
                    "status": "ACTIVE",
                    "name": "이정우",
                    "memberNumber": "M-2025110301",
                    "email": "lee.jungwoo@example.com",
                    "zipCode": "03154",
                    "address": "서울특별시 종로구 세종대로 150",
                    "detailedAddress": "광화문 빌딩 501호",
                    "mobileNumber": "010-9988-7766",
                    "landlineNumber": "02-1111-2222",
                    "registrationDate": "2025-11-03",
                    "isSmsSendingAllowed": true,
                    "memo": "프리미엄 구독 회원"
                  },
                  "paymentMethods": {
                    "cms": [
                      {
                        "paymentMethodId": 1512431,
                        "memberId": 15123412,
                        "isRecurringPaymentAgreed": true,
                        "bankName": "신한은행",
                        "accountNumber": "110-345-678901",
                        "accountHolderName": "이정우",
                        "accountHolderType": "PERSONAL",
                        "dateOfBirth": "19950515",
                        "businessRegistrationNumber": null,
                        "consentInformation": "CMS 동의 완료"
                      }
                    ],
                    "rcms": [
                      {
                        "paymentMethodId": 513412,
                        "memberId": 15123412,
                        "isRecurringPaymentAgreed": false,
                        "bankName": "우리은행",
                        "accountNumber": "1002-123-456789",
                        "accountHolderName": "스타트업 코리아",
                        "accountHolderType": "BUSINESS",
                        "dateOfBirth": null,
                        "businessRegistrationNumber": "501-81-12345",
                        "consentInformation": "RCMS 동의 필요"
                      }
                    ],
                    "card": [
                      {
                        "paymentMethodId": 51231,
                        "memberId": 15123412,
                        "isRecurringPaymentAgreed": true,
                        "cardNumber": "4560-xxxx-xxxx-1234",
                        "cardHolderName": "이정우",
                        "cardHolderType": "INDIVIDUAL",
                        "dateOfBirth": "19950515",
                        "businessRegistrationNumber": null
                      }
                    ],
                    "mobile": [
                      {
                        "paymentMethodId": 512312,
                        "memberId": 15123412,
                        "isRecurringPaymentAgreed": true,
                        "telecomCompany": "SKT",
                        "mobileNumber": "010-9988-7766",
                        "residentRegistrationNumber": "950515-1xxxxxx",
                        "mobileHolderName": "이정우"
                      }
                    ],
                    "virtualAccount": [
                      {
                        "paymentMethodId": 5142324,
                        "memberId": 15123412,
                        "isRecurringPaymentAgreed": false,
                        "bankName": "농협은행",
                        "accountNumber": "777-01-123456",
                        "accountHolderName": "주식회사 ABC솔루션"
                      }
                    ],
                    "payerPayment": [
                      {
                        "paymentMethodId": 5124124,
                        "memberId": 15123412,
                        "isRecurringPaymentAgreed": true,
                        "isCardEnabled": true,
                        "isAccountEnabled": false,
                        "isSimplePaymentEnabled": true
                      }
                    ]
                  },
                  "proofs": {
                    "cashReceipt": [
                      {
                        "proofId": 514124,
                        "memberId": 15123412,
                        "isAutomatedIssuance": true,
                        "cashReceiptInformation": "개인 소득공제용 (010-9988-7766)"
                      }
                    ],
                    "taxInvoice": [
                      {
                        "proofId": 4143123,
                        "memberId": 15123412,
                        "isAutomatedIssuance": true,
                        "memberType": "BUSINESS",
                        "taxType": "GENERAL",
                        "registrationNumber": "501-81-12345",
                        "tradeName": "스타트업 코리아",
                        "representativeName": "박영희",
                        "itemName": "월간 소프트웨어 라이선스",
                        "issuanceType": "EMAIL"
                      }
                    ]
                  }
                }]
                """;
        return jsonString;
    }
}
