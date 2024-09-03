package com.akash.productservicesnew.services.DB;

import com.akash.productservicesnew.dtos.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ProductServiceDB {
    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(String id);
    void deleteProductById(String id);
    void addNewProduct(ProductDTO productDTO);
    void addNewProductToCategory(ProductDTO productDTO, UUID categoryId);
    void updateProductTitle(String id, String newTitle);
}
