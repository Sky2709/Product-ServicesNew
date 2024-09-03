package com.akash.productservicesnew.services.fakeStoreService;

import com.akash.productservicesnew.dtos.GenericProductDTO;
import com.akash.productservicesnew.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<GenericProductDTO> getAllProducts();

    GenericProductDTO getProductById(Long id) throws NotFoundException;

//    List<String> getAllCategories();
//
//    List<ProductDTO> getAllProductsInCategory(String name);

    GenericProductDTO addNewProduct(GenericProductDTO genericProductDTO);

    GenericProductDTO updateProduct(GenericProductDTO genericProductDTO, Long id) throws NotFoundException;


    GenericProductDTO deleteProduct(Long id) throws NotFoundException;




}
