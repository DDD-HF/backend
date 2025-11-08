package com.example.domain.member;

import com.example.domain.common.annotation.DomainService;
import com.example.domain.member.api.RegisterProofUseCase;
import com.example.domain.member.api.dto.ProofCommand;
import com.example.domain.member.model.CashReceipt;
import com.example.domain.member.model.Proof;
import com.example.domain.member.model.ProofId;
import com.example.domain.member.model.TaxInvoice;
import com.example.domain.member.spi.IdGenerator;
import com.example.domain.member.spi.ProofRepository;

@DomainService
public class RegisterProofService implements RegisterProofUseCase {

    private final IdGenerator idGenerator;
    private final ProofRepository proofRepository;

    public RegisterProofService(IdGenerator idGenerator, ProofRepository proofRepository) {
        this.idGenerator = idGenerator;
        this.proofRepository = proofRepository;
    }

    @Override
    public Proof execute(ProofCommand.Register command) {
        ProofId proofId = new ProofId(idGenerator.generateId());
        Proof proof = ProofFactory.create(command, proofId);

        return proofRepository.save(proof);
    }

    private static class ProofFactory {

        private static Proof create(ProofCommand.Register command, ProofId proofId) {
            return switch (command.proofType()) {
                case 현금영수증 -> new CashReceipt(
                        proofId,
                        command.memberId(),
                        command.cashReceipt().isAutomatedIssuance(),
                        command.cashReceipt().cashReceiptInformation()
                );
                case 세금계산서 -> new TaxInvoice(
                        proofId,
                        command.memberId(),
                        command.taxInvoice().isAutomatedIssuance(),
                        command.taxInvoice().memberType(),
                        command.taxInvoice().taxType(),
                        command.taxInvoice().registrationNumber(),
                        command.taxInvoice().tradeName(),
                        command.taxInvoice().representativeName(),
                        command.taxInvoice().itemName(),
                        command.taxInvoice().issuanceType()
                );
            };
        }
    }
}
