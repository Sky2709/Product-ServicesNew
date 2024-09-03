package com.akash.productservicesnew.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Product extends BaseModel {

    private String title;
    private String description;
    private String image;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "category")
    @JsonBackReference
    private Category category;
    @OneToOne
    private Price price;



}
