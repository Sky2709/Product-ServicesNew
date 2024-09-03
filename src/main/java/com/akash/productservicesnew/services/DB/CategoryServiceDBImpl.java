package com.akash.productservicesnew.services.DB;

import com.akash.productservicesnew.dtos.CategoryDTO;
import com.akash.productservicesnew.dtos.ProductDTO;
import com.akash.productservicesnew.models.Category;
import com.akash.productservicesnew.models.Product;
import com.akash.productservicesnew.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceDBImpl implements CategoryServiceDB {

    private final CategoryRepository categoryRepository;

    public CategoryServiceDBImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(this::convertCategoryToCategoryDTO).toList();
    }

    @Override
    public CategoryDTO getCategory(String categoryUUID) {
        Optional<Category> categoryOptional = categoryRepository.findById(UUID.fromString(categoryUUID));
        if (categoryOptional.isEmpty()) {
            return null;
        }
        Category category = categoryOptional.get();
        return convertCategoryToCategoryDTO(category);

    }

    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        return categoryRepository.save(category);
    }

    @Override
    public List<ProductDTO> getProductsByCategory(String categoryUUID) {
        Optional<Category> categoryOptional = categoryRepository.findById(UUID.fromString(categoryUUID));
        if (categoryOptional.isEmpty()) {
            return null;
        }
        Category category = categoryOptional.get();
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
        Optional<Category> categoryOptional = categoryRepository.findById(UUID.fromString(categoryUUID));
        if (categoryOptional.isEmpty()) {
            return null;
        }
        Category category = categoryOptional.get();
        CategoryDTO categoryDTO = convertCategoryToCategoryDTO(category);
        return categoryDTO.getName();

    }

    @Override
    public List<String> getProductsNameByCategoryId(String categoryUUID) {
        Optional<Category> categoryOptional = categoryRepository.findById(UUID.fromString(categoryUUID));
        if (categoryOptional.isEmpty()) {
            return null;
        }
        Category category = categoryOptional.get();
        List<Product> products = category.getProducts();
        return products.stream().map(Product::getTitle).toList();
    }

    public CategoryDTO convertCategoryToCategoryDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }
}
