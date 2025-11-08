package com.example.domain.member;

import com.example.domain.common.annotation.DomainService;
import com.example.domain.member.api.RegisterPaymentMethodUseCase;
import com.example.domain.member.api.dto.PaymentMethodCommand;
import com.example.domain.member.model.Card;
import com.example.domain.member.model.Cms;
import com.example.domain.member.model.Mobile;
import com.example.domain.member.model.PayerPayment;
import com.example.domain.member.model.PaymentMethod;
import com.example.domain.member.model.PaymentMethodId;
import com.example.domain.member.model.Rcms;
import com.example.domain.member.model.VirtualAccount;
import com.example.domain.member.spi.IdGenerator;
import com.example.domain.member.spi.PaymentMethodRepository;

@DomainService
public class RegisterPaymentMethodService implements RegisterPaymentMethodUseCase {

    private final IdGenerator idGenerator;
    private final PaymentMethodRepository paymentMethodRepository;

    public RegisterPaymentMethodService(IdGenerator idGenerator, PaymentMethodRepository paymentMethodRepository) {
        this.idGenerator = idGenerator;
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @Override
    public PaymentMethod execute(PaymentMethodCommand.Register command) {
        PaymentMethodId paymentMethodId = new PaymentMethodId(idGenerator.generateId());
        PaymentMethod paymentMethod = PaymentMethodFactory.create(command, paymentMethodId);

        return paymentMethodRepository.save(paymentMethod);
    }

    private static class PaymentMethodFactory {

        private static PaymentMethod create(PaymentMethodCommand.Register command, PaymentMethodId paymentMethodId) {
            return switch (command.paymentMethodType()) {
                case CMS -> new Cms(
                        paymentMethodId,
                        command.memberId(),
                        command.isRecurringPaymentAgreed(),
                        command.cms().bankName(),
                        command.cms().accountNumber(),
                        command.cms().accountHolderName(),
                        command.cms().accountHolderType(),
                        command.cms().dateOfBirth(),
                        command.cms().businessRegistrationNumber(),
                        command.cms().consentInformation()
                );
                case 실시간CMS -> new Rcms(
                        paymentMethodId,
                        command.memberId(),
                        command.isRecurringPaymentAgreed(),
                        command.rcms().bankName(),
                        command.rcms().accountNumber(),
                        command.rcms().accountHolderName(),
                        command.rcms().accountHolderType(),
                        command.rcms().dateOfBirth(),
                        command.rcms().businessRegistrationNumber(),
                        command.rcms().consentInformation()
                );
                case 카드 -> new Card(
                        paymentMethodId,
                        command.memberId(),
                        command.isRecurringPaymentAgreed(),
                        command.card().cardNumber(),
                        command.card().cardHolderName(),
                        command.card().cardHolderType(),
                        command.card().dateOfBirth(),
                        command.card().businessRegistrationNumber()
                );
                case 휴대전화 -> new Mobile(
                        paymentMethodId,
                        command.memberId(),
                        command.isRecurringPaymentAgreed(),
                        command.mobile().telecomCompany(),
                        command.mobile().mobileNumber(),
                        command.mobile().residentRegistrationNumber(),
                        command.mobile().mobileHolderName()
                );
                case 가상계좌 -> new VirtualAccount(
                        paymentMethodId,
                        command.memberId(),
                        command.isRecurringPaymentAgreed(),
                        command.virtualAccount().bankName(),
                        command.virtualAccount().accountNumber(),
                        command.virtualAccount().accountHolderName()
                );
                case 납부자결제 -> new PayerPayment(
                        paymentMethodId,
                        command.memberId(),
                        command.isRecurringPaymentAgreed(),
                        command.payerPayment().isCardEnabled(),
                        command.payerPayment().isAccountEnabled(),
                        command.payerPayment().isSimplePaymentEnabled()
                );
            };
        }
    }
}
