package com.akash.productservicesnew.services.fakeStoreService;

import com.akash.productservicesnew.dtos.ProductDTO;
import com.akash.productservicesnew.services.CategoryService;
import com.akash.productservicesnew.thirdPartyClients.fakeStore.FakeStoreCategoryServiceClient;
import com.akash.productservicesnew.thirdPartyClients.fakeStore.FakeStoreProductDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreCategoryService implements CategoryService {
    private final FakeStoreCategoryServiceClient fakeStoreCategoryServiceClient;

    public FakeStoreCategoryService(FakeStoreCategoryServiceClient fakeStoreCategoryServiceClient) {
        this.fakeStoreCategoryServiceClient = fakeStoreCategoryServiceClient;
    }

    @Override
    public List<String> getAllCategories() {
        List<String> categoryList = new ArrayList<>();
        List<String> fakeStoreCategoryList = fakeStoreCategoryServiceClient.getAllCategories();
        categoryList.addAll(fakeStoreCategoryList);
        return categoryList;
    }

    @Override
    public List<ProductDTO> getAllProductsInCategory(String name) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        List<FakeStoreProductDTO> fakeStoreProductDTOList = fakeStoreCategoryServiceClient.getAllProductsInCategory(name);
        for (FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOList) {
            productDTOList.add(converter(fakeStoreProductDTO));
        }
        return productDTOList;
    }

    private ProductDTO converter(FakeStoreProductDTO fakeStoreProductDTO) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(fakeStoreProductDTO.getId());
        productDTO.setTitle(fakeStoreProductDTO.getTitle());
        productDTO.setPrice(fakeStoreProductDTO.getPrice());
        productDTO.setCategory(fakeStoreProductDTO.getCategory());
        productDTO.setDescription(fakeStoreProductDTO.getDescription());
        productDTO.setImage(fakeStoreProductDTO.getImage());
        return productDTO;
    }


}
