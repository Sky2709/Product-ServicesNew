package com.akash.productservicesnew.services.fakeStoreService;

import com.akash.productservicesnew.exceptions.NotFoundException;

import com.akash.productservicesnew.thirdPartyClients.fakeStore.FakeStoreProductDTO;
import com.akash.productservicesnew.thirdPartyClients.fakeStore.FakeStoreProductServiceClient;
import com.akash.productservicesnew.dtos.GenericProductDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    private final FakeStoreProductServiceClient fakeStoreProductServiceClient;
//    private FakeStoreCategoryServiceClient fakeStoreCategoryServiceClient;

    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient) {
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }

//    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient,
//                                   FakeStoreCategoryServiceClient fakeStoreCategoryServiceClient) {
//        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
//        this.fakeStoreCategoryServiceClient = fakeStoreCategoryServiceClient;
//    }

    @Override
    public List<GenericProductDTO> getAllProducts() {
        List<GenericProductDTO> genericProductDTOList = new ArrayList<>();
        List<FakeStoreProductDTO> fakeStoreProductDTOList = fakeStoreProductServiceClient.getAllProducts();
        for (FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOList) {
            genericProductDTOList.add(converter(fakeStoreProductDTO));
        }
        return genericProductDTOList;
    }

    @Override
    public GenericProductDTO getProductById(Long id) throws NotFoundException {
        return converter(fakeStoreProductServiceClient.getProductById(id));
    }

//    @Override
//    public List<String> getAllCategories() {
//        List<String> categoryList = new ArrayList<>();
//        List<String> fakeStoreCategoryList = fakeStoreCategoryServiceClient.getAllCategories();
//        categoryList.addAll(fakeStoreCategoryList);
//        return categoryList;
//    }
//
//    @Override
//    public List<ProductDTO> getAllProductsInCategory(String name) {
//        List<ProductDTO> productDTOList = new ArrayList<>();
//        List<FakeStoreProductDTO> fakeStoreProductDTOList = fakeStoreCategoryServiceClient.getAllProductsInCategory(name);
//        for (FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOList) {
//            productDTOList.add(converter(fakeStoreProductDTO));
//        }
//        return productDTOList;
//    }

    @Override
    public GenericProductDTO addNewProduct(GenericProductDTO genericProductDTO) {
        return converter(fakeStoreProductServiceClient.addNewProduct(genericProductDTO));
    }

    @Override
    public GenericProductDTO updateProduct(GenericProductDTO genericProductDTO, Long id) throws NotFoundException {
        return converter(fakeStoreProductServiceClient.updateProduct(genericProductDTO, id));
    }

    @Override
    public GenericProductDTO deleteProduct(Long id) throws NotFoundException {
        return converter(fakeStoreProductServiceClient.deleteProduct(id));
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
