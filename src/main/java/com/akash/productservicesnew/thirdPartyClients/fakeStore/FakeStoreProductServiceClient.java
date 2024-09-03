package com.akash.productservicesnew.thirdPartyClients.fakeStore;

import com.akash.productservicesnew.dtos.GenericProductDTO;
import com.akash.productservicesnew.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class FakeStoreProductServiceClient {

    private final RestTemplateBuilder restTemplateBuilder;

//    @Value("${fakeStore.api.url}")
//    private String fakeStoreURl;
//
//    @Value("${fakeStore.api.paths.products}")
//    private String fakeStoreProductsURL;

    private final String productRequestURL;
    private final String productRequestByIDURL;
//    private final String allCategories;
//    private final String productsInCategory;

    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder,
                                         @Value("${fakeStore.api.url}") String fakeStoreURl,
                                         @Value("${fakeStore.api.paths.products}") String fakeStoreProductsURL) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.productRequestURL = fakeStoreURl + fakeStoreProductsURL;
        this.productRequestByIDURL = fakeStoreURl + fakeStoreProductsURL + "/{id}";
//        this.allCategories = fakeStoreURl + fakeStoreProductsURL + "/categories";
//        this.productsInCategory = fakeStoreURl + fakeStoreProductsURL + "/category/{name}";
    }

    public List<FakeStoreProductDTO> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO[]> response = restTemplate.getForEntity(productRequestURL, FakeStoreProductDTO[].class);
        return Arrays.stream(Objects.requireNonNull(response.getBody())).toList();
    }

    public FakeStoreProductDTO getProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.getForEntity(productRequestByIDURL, FakeStoreProductDTO.class, id);
        FakeStoreProductDTO fakeStoreProductDTO = response.getBody();
        if (fakeStoreProductDTO == null) {
            throw new NotFoundException("not found with id: " + id);
        }
        return fakeStoreProductDTO;
    }

//    public List<String> getAllCategories() {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<String[]> response = restTemplate.getForEntity(allCategories, String[].class);
//        return Arrays.stream(response.getBody()).toList();
//    }
//
//    public List<FakeStoreProductDTO> getAllProductsInCategory(String name) {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDTO[]> response = restTemplate.getForEntity(productsInCategory, FakeStoreProductDTO[].class, name);
//        return Arrays.stream(response.getBody()).toList();
//    }

    public FakeStoreProductDTO addNewProduct(GenericProductDTO genericProductDTO) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.postForEntity(productRequestURL, genericProductDTO, FakeStoreProductDTO.class);
        return response.getBody();
    }

    public FakeStoreProductDTO updateProduct(GenericProductDTO genericProductDTO, Long id) throws NotFoundException {
        RestTemplate restTemplate= restTemplateBuilder.build();
        HttpEntity<GenericProductDTO> request = new HttpEntity<>(genericProductDTO);
        ResponseEntity<FakeStoreProductDTO> response= restTemplate.exchange(
                productRequestByIDURL,
                HttpMethod.PUT,
                request,
                FakeStoreProductDTO.class,
                id
        );
        FakeStoreProductDTO fakeStoreProductDTO = response.getBody();
        if (fakeStoreProductDTO == null) {
            throw new NotFoundException("not found with id: " + id);
        }
        return fakeStoreProductDTO;
    }

    public FakeStoreProductDTO deleteProduct(Long id) throws NotFoundException {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> response=restTemplate.getForEntity(productRequestByIDURL, FakeStoreProductDTO.class, id);
        FakeStoreProductDTO fakeStoreProductDTO = response.getBody();
        if (fakeStoreProductDTO == null) {
            throw new NotFoundException("not found with id: " + id);
        }
        restTemplate.delete(productRequestByIDURL, id);
        return fakeStoreProductDTO;
    }
}
