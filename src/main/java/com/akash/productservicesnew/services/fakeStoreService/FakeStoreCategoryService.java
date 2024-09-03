package com.akash.productservicesnew.services.fakeStoreService;

import com.akash.productservicesnew.dtos.GenericProductDTO;
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
    public List<GenericProductDTO> getAllProductsInCategory(String name) {
        List<GenericProductDTO> genericProductDTOList = new ArrayList<>();
        List<FakeStoreProductDTO> fakeStoreProductDTOList = fakeStoreCategoryServiceClient.getAllProductsInCategory(name);
        for (FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOList) {
            genericProductDTOList.add(converter(fakeStoreProductDTO));
        }
        return genericProductDTOList;
    }

    private GenericProductDTO converter(FakeStoreProductDTO fakeStoreProductDTO) {
        GenericProductDTO genericProductDTO = new GenericProductDTO();
        genericProductDTO.setId(fakeStoreProductDTO.getId());
        genericProductDTO.setTitle(fakeStoreProductDTO.getTitle());
        genericProductDTO.setPrice(fakeStoreProductDTO.getPrice());
        genericProductDTO.setCategory(fakeStoreProductDTO.getCategory());
        genericProductDTO.setDescription(fakeStoreProductDTO.getDescription());
        genericProductDTO.setImage(fakeStoreProductDTO.getImage());
        return genericProductDTO;
    }


}
