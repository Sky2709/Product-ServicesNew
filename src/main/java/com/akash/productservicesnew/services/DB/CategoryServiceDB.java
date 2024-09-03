package com.akash.productservicesnew.services.DB;

import com.akash.productservicesnew.dtos.CategoryDTO;
import com.akash.productservicesnew.dtos.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryServiceDB {
    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategory(String categoryUUID);

    void createCategory(CategoryDTO categoryDTO);

    List<ProductDTO> getProductsByCategory(String categoryUUID);

    String getCategoryNameById(String categoryUUID);

    List<String> getProductsNameByCategoryId(String categoryUUID);
}
