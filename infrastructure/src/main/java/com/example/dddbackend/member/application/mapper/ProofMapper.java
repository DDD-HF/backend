package com.example.dddbackend.member.application.mapper;

import com.example.dddbackend.common.configuration.MapStructConfig;
import com.example.dddbackend.member.presentation.dto.RegisterProofRequest;
import com.example.domain.member.api.dto.ProofCommand;
import com.example.domain.member.model.CashReceipt;
import com.example.domain.member.model.MemberId;
import com.example.domain.member.model.Proof;
import com.example.domain.member.model.TaxInvoice;
import com.example.domain.member.spi.dto.MemberView;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper(config = MapStructConfig.class)
public interface ProofMapper {

    ProofCommand.Register toCommand(RegisterProofRequest request, MemberId memberId);

    ProofCommand.Register.CashReceipt toCommand(RegisterProofRequest.CashReceipt cashReceipt);

    ProofCommand.Register.TaxInvoice toCommand(RegisterProofRequest.TaxInvoice taxInvoice);

    @Mapping(source = "proofId.id", target = "proofId")
    @Mapping(source = "memberId.id", target = "memberId")
    MemberView.CashReceipt toCashReceiptDto(CashReceipt card);
    @Mapping(source = "proofId.id", target = "proofId")
    @Mapping(source = "memberId.id", target = "memberId")
    MemberView.TaxInvoice toTaxInvoiceDto(TaxInvoice card);

    default MemberView.Proof toProofsDto(List<Proof> proofList) {
        var cashReceiptList = new ArrayList<MemberView.CashReceipt>();
        var taxInvoiceList = new ArrayList<MemberView.TaxInvoice>();

        for (Proof proof : proofList) {
            switch (proof) {
                case CashReceipt cashReceipt -> cashReceiptList.add(toCashReceiptDto(cashReceipt));
                case TaxInvoice taxInvoice -> taxInvoiceList.add(toTaxInvoiceDto(taxInvoice));
            }
        }

        return new MemberView.Proof(
                cashReceiptList, taxInvoiceList
        );
    }

}
