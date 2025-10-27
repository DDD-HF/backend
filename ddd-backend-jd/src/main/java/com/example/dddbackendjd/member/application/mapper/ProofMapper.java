package com.example.dddbackendjd.member.application.mapper;

import com.example.dddbackendjd.common.configuration.MapStructConfig;
import com.example.dddbackendjd.member.domain.api.dto.ProofCommand;
import com.example.dddbackendjd.member.presentation.dto.RegisterProofRequest;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfig.class)
public interface ProofMapper {

    ProofCommand.Register toCommand(RegisterProofRequest request);

    ProofCommand.Register.CashReceipt toCommand(RegisterProofRequest.CashReceipt cashReceipt);

    ProofCommand.Register.TaxInvoice toCommand(RegisterProofRequest.TaxInvoice taxInvoice);

}
