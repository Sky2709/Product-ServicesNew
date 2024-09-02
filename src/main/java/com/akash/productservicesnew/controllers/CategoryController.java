package com.akash.productservicesnew.controllers;

import com.akash.productservicesnew.dtos.ProductDTO;
import com.akash.productservicesnew.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private ProductService productService;

    public CategoryController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<String> getAllCategories() {
        return productService.getAllCategories();
    }

    @GetMapping("/{name}")
    public List<ProductDTO> getAllProductsInCategory(@PathVariable("name") String name) {
        return productService.getAllProductsInCategory(name);
    }



}
