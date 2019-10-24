package com.example.poc_axon_saga.signature.sagas;

import com.example.poc_axon_saga.signature.commands.ApplySignatureCommand;
import com.example.poc_axon_saga.signature.events.SignatureAppliedEvent;
import com.example.poc_axon_saga.signature.events.SignatureCreatedEvent;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.EndSaga;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Saga
public class SignDocumentSaga {

    @Autowired
    private CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "signatureId")
    public void handle(SignatureCreatedEvent signatureCreatedEvent) {
        UUID documentId = signatureCreatedEvent.getDocumentId();
        UUID signatureId = signatureCreatedEvent.getSignatureId();
        SagaLifecycle.associateWith("signatureId", signatureId.toString());
        commandGateway.send(new ApplySignatureCommand(documentId, signatureId));
    }

    @EndSaga
    @SagaEventHandler(associationProperty = "signatureId")
    public void handle(SignatureAppliedEvent signatureAppliedEvent) {
        SagaLifecycle.end();
    }
}
