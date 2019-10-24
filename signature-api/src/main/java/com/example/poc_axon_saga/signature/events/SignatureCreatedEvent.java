package com.example.poc_axon_saga.signature.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.AggregateIdentifier;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignatureCreatedEvent {
    private UUID documentId;
    @AggregateIdentifier
    private UUID signatureId;
}
