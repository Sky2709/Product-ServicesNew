package com.akash.productservicesnew.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Price extends BaseModel {
    private double value;
    private String currency;
}
