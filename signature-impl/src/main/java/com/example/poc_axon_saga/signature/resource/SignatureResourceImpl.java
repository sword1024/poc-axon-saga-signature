package com.example.poc_axon_saga.signature.resource;

import com.example.poc_axon_saga.signature.dto.SignatureDto;
import com.example.poc_axon_saga.signature.service.SignatureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SignatureResourceImpl implements SignatureResource {

    private final SignatureService signatureService;
    private final MapperFacade mapperFacade;

    @Override
    public List<SignatureDto> getByDocumentId(UUID documentId) {
        return signatureService.findByDocumentId(documentId, s -> mapperFacade.map(s, SignatureDto.class));
    }
}
