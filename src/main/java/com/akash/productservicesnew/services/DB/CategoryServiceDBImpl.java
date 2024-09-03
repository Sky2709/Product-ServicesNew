package com.akash.productservicesnew.services.DB;

import com.akash.productservicesnew.dtos.ProductDTO;
import com.akash.productservicesnew.models.Category;
import com.akash.productservicesnew.models.Product;
import com.akash.productservicesnew.repositories.CategoryRepository;
import com.akash.productservicesnew.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CategoryServiceDBImpl implements CategoryServiceDB {

    private final CategoryRepository categoryRepository;

    public CategoryServiceDBImpl(CategoryRepository categoryRepository,
                                 ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getCategory(String categoryUUID) {
        Optional<Category> categoryOptional = categoryRepository.findById(UUID.fromString(categoryUUID));
        return categoryOptional.orElse(null);
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<ProductDTO> getProductsByCategory(String categoryUUID) {
        Category category = getCategory(categoryUUID);

        List<Product> productDTOS = category.getProducts();
        return productDTOS.stream().map(product -> {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setTitle(product.getTitle());
            productDTO.setDescription(product.getDescription());
            productDTO.setImage(product.getImage());
            productDTO.setCategory(product.getCategory());
            productDTO.setPrice(product.getPrice());
            return productDTO;
        }).toList();
    }

    @Override
    public String getCategoryNameById(String categoryUUID) {
        Category category = getCategory(categoryUUID);
        return category.getName();
    }

    @Override
    public List<String> getProductsNameByCategoryId(String categoryUUID) {
        Category category = getCategory(categoryUUID);
        List<Product> products = category.getProducts();
        return products.stream().map(Product::getTitle).toList();
    }
}
