package com.example.poc_axon_saga.signature.repository;

import com.example.poc_axon_saga.signature.model.Signature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SignatureRepository extends JpaRepository<Signature, UUID> {
    List<Signature> findByDocumentId(UUID documentId);
}
