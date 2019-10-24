package com.example.poc_axon_saga.signature.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignatureFailedEvent {
    private UUID documentId;
    private UUID signatureId;
}
