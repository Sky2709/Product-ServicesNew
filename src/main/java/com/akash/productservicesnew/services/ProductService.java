package com.akash.productservicesnew.services;

import com.akash.productservicesnew.dtos.ProductDTO;
import com.akash.productservicesnew.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(Long id) throws NotFoundException;

//    List<String> getAllCategories();
//
//    List<ProductDTO> getAllProductsInCategory(String name);

    ProductDTO addNewProduct(ProductDTO productDTO);

    ProductDTO updateProduct(ProductDTO productDTO, Long id) throws NotFoundException;


    ProductDTO deleteProduct(Long id) throws NotFoundException;




}
