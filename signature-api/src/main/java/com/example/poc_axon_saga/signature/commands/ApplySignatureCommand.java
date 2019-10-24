package com.example.poc_axon_saga.signature.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplySignatureCommand {
    private UUID documentId;
    @TargetAggregateIdentifier
    private UUID signatureId;
}
