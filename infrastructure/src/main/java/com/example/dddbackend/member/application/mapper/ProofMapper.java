package com.example.dddbackend.member.application.mapper;

import com.example.dddbackend.common.configuration.MapStructConfig;
import com.example.domain.member.api.dto.ProofCommand;
import com.example.dddbackend.member.presentation.dto.RegisterProofRequest;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfig.class)
public interface ProofMapper {

    ProofCommand.Register toCommand(RegisterProofRequest request);

    ProofCommand.Register.CashReceipt toCommand(RegisterProofRequest.CashReceipt cashReceipt);

    ProofCommand.Register.TaxInvoice toCommand(RegisterProofRequest.TaxInvoice taxInvoice);

}
