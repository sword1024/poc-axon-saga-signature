package com.example.poc_axon_saga.signature.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSignatureCommand {
    private UUID documentId;
    private String signatureData;
}
