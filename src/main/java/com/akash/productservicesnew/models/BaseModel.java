package com.akash.productservicesnew.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public class BaseModel {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @Column(name="id", columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    private UUID id;
}
