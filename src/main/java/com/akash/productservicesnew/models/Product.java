package com.akash.productservicesnew.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseModel {

    private String title;
    private double price;
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;
    private String description;
    private String image;



}
