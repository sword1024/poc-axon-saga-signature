package com.example.poc_axon_saga.signature.resource;

import com.example.poc_axon_saga.signature.dto.SignatureDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@RequestMapping("signature")
public interface SignatureResource {

    @GetMapping("/{documentId}")
    List<SignatureDto> getByDocumentId(@PathVariable("documentId") UUID documentId);
}
