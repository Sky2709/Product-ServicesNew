package com.akash.productservicesnew.controllers;

import com.akash.productservicesnew.dtos.ProductDTO;
import com.akash.productservicesnew.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<String> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{name}")
    public List<ProductDTO> getAllProductsInCategory(@PathVariable("name") String name) {
        return categoryService.getAllProductsInCategory(name);
    }

}
