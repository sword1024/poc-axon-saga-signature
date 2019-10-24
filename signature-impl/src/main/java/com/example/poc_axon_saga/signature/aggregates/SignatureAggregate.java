package com.example.poc_axon_saga.signature.aggregates;

import com.example.poc_axon_saga.signature.commands.CreateSignatureCommand;
import com.example.poc_axon_saga.signature.events.SignatureAppliedEvent;
import com.example.poc_axon_saga.signature.events.SignatureCreatedEvent;
import com.example.poc_axon_saga.signature.service.SignatureService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Aggregate
@Slf4j
@NoArgsConstructor
public class SignatureAggregate {
    @Autowired
    private SignatureService signatureService;

    @AggregateIdentifier
    private UUID signatureId;

    @CommandHandler
    public void on(CreateSignatureCommand command) {
        UUID documentId = command.getDocumentId();
        signatureId = signatureService.createSignature(documentId, command.getSignatureData());
        AggregateLifecycle.apply(new SignatureCreatedEvent(documentId, signatureId));
    }

    @EventSourcingHandler
    protected void on(SignatureAppliedEvent event) {
        signatureService.applySignature(event.getSignatureId());
    }
}
