package com.akash.productservicesnew.services;

import com.akash.productservicesnew.dtos.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<String> getAllCategories();

    List<ProductDTO> getAllProductsInCategory(String name);

}
