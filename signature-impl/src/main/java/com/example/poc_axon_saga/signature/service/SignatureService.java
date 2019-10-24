package com.example.poc_axon_saga.signature.service;

import com.example.poc_axon_saga.signature.model.Signature;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

public interface SignatureService {
    <R> List<R> findByDocumentId(UUID documentId, Function<Signature, R> resultConverter);

    UUID createSignature(UUID documentId, String signatureData);

    void applySignature(UUID signatureId);
}
