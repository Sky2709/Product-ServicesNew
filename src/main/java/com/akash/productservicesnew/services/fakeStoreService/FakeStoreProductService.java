package com.akash.productservicesnew.services.fakeStoreService;

import com.akash.productservicesnew.exceptions.NotFoundException;

import com.akash.productservicesnew.services.ProductService;

import com.akash.productservicesnew.thirdPartyClients.fakeStore.FakeStoreProductDTO;
import com.akash.productservicesnew.thirdPartyClients.fakeStore.FakeStoreProductServiceClient;
import com.akash.productservicesnew.dtos.ProductDTO;
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
    public List<ProductDTO> getAllProducts() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        List<FakeStoreProductDTO> fakeStoreProductDTOList = fakeStoreProductServiceClient.getAllProducts();
        for (FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOList) {
            productDTOList.add(converter(fakeStoreProductDTO));
        }
        return productDTOList;
    }

    @Override
    public ProductDTO getProductById(Long id) throws NotFoundException {
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
    public ProductDTO addNewProduct(ProductDTO productDTO) {
        return converter(fakeStoreProductServiceClient.addNewProduct(productDTO));
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO, Long id) throws NotFoundException {
        return converter(fakeStoreProductServiceClient.updateProduct(productDTO, id));
    }

    @Override
    public ProductDTO deleteProduct(Long id) throws NotFoundException {
        return converter(fakeStoreProductServiceClient.deleteProduct(id));
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
