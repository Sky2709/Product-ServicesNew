package com.akash.productservicesnew.dtos;

import com.akash.productservicesnew.models.Category;
import com.akash.productservicesnew.models.Price;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {
    private String title;
    private String description;
    private String image;
    private Category category;
    private Price price;
}
