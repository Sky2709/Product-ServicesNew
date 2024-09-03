package com.akash.productservicesnew.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;

import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Category extends BaseModel{
    private String name;
    @OneToMany(mappedBy = "category", targetEntity = Product.class, fetch = FetchType.LAZY)
    private List<Product> products;
}
