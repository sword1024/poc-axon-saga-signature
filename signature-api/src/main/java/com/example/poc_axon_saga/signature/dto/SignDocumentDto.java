package com.example.poc_axon_saga.signature.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignDocumentDto {
    private UUID documentId;
    private String signatureData;
}
