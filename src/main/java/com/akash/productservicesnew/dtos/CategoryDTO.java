package com.akash.productservicesnew.dtos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDTO {
    private String name;
    @JsonManagedReference // This is used to break the infinite recursion while serializing the object
    private List<ProductDTO> products;


}
