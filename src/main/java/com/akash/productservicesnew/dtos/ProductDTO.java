package com.akash.productservicesnew.dtos;

import com.akash.productservicesnew.models.Category;
import com.akash.productservicesnew.models.Price;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {
    private String title;
    private String description;
    private String image;
    @JsonBackReference // This is used to break the infinite recursion while serializing the object
    private Category category;
    private Price price;
}
