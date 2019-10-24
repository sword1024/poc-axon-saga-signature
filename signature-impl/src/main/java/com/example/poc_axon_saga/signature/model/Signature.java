package com.example.poc_axon_saga.signature.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Version;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
@Accessors(chain = true)
public class Signature {
    @Id
    private UUID id;

    @Version
    private long version;

    private UUID documentId;
    private String data;

    @Enumerated(EnumType.STRING)
    private SignatureStatus status;
}
