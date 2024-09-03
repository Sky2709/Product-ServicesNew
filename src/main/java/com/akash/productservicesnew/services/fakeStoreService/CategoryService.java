package com.akash.productservicesnew.services.fakeStoreService;

import com.akash.productservicesnew.dtos.GenericProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<String> getAllCategories();
    List<GenericProductDTO> getAllProductsInCategory(String name);

}
