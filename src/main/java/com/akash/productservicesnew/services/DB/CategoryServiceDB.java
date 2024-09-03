package com.akash.productservicesnew.services.DB;

import com.akash.productservicesnew.dtos.ProductDTO;
import com.akash.productservicesnew.models.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryServiceDB {
    Category getCategory(String categoryUUID);

    Category createCategory(Category category);

    List<ProductDTO> getProductsByCategory(String categoryUUID);

    String getCategoryNameById(String categoryUUID);

    List<String> getProductsNameByCategoryId(String categoryUUID);
}
