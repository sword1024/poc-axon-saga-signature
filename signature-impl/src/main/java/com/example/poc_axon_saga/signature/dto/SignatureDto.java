package com.example.poc_axon_saga.signature.dto;

import com.example.poc_axon_saga.signature.model.SignatureStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignatureDto {
    private UUID id;
    private String data;
    private SignatureStatus status;
}
