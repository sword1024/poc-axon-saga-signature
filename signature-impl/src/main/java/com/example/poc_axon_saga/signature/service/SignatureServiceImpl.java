package com.example.poc_axon_saga.signature.service;

import com.example.poc_axon_saga.signature.model.Signature;
import com.example.poc_axon_saga.signature.model.SignatureStatus;
import com.example.poc_axon_saga.signature.repository.SignatureRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SignatureServiceImpl implements SignatureService {
    private final SignatureRepository repository;

    @Override
    public <R> List<R> findByDocumentId(UUID documentId, Function<Signature, R> resultConverter) {
        return repository.findByDocumentId(documentId).stream().map(resultConverter).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public UUID createSignature(UUID documentId, String signatureData) {
        //TODO check signature data

        Signature signature = repository.save(new Signature()
                .setId(UUID.randomUUID())
                .setDocumentId(documentId)
                .setData(signatureData)
                .setStatus(SignatureStatus.PENDING));

        return signature.getId();
    }

    @Transactional
    @Override
    public void applySignature(UUID signatureId) {
        Signature signature = repository.findById(signatureId).orElseThrow(() -> new EntityNotFoundException(signatureId.toString()));
        signature.setStatus(SignatureStatus.CREATED);
    }
}
