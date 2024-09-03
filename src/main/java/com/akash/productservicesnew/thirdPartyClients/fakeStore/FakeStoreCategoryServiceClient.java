package com.akash.productservicesnew.thirdPartyClients.fakeStore;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class FakeStoreCategoryServiceClient {
    private final RestTemplateBuilder restTemplateBuilder;

//    @Value("${fakeStore.api.url}")
//    private String fakeStoreURl;
//
//    @Value("${fakeStore.api.paths.categories}")
//    private String fakeStoreCategoriesURL;

    private final String allCategories;
    private final String productsInCategory;

    public FakeStoreCategoryServiceClient(RestTemplateBuilder restTemplateBuilder,
                                          @Value("${fakeStore.api.url}") String fakeStoreURl,
                                          @Value("${fakeStore.api.paths.categories}") String fakeStoreCategoriesURL) {
        this.restTemplateBuilder = restTemplateBuilder;
        allCategories = fakeStoreURl + fakeStoreCategoriesURL;
        productsInCategory = fakeStoreURl + fakeStoreCategoriesURL + "/{name}";

    }

    public List<String> getAllCategories() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String[]> response = restTemplate.getForEntity(allCategories, String[].class);
        return Arrays.stream(Objects.requireNonNull(response.getBody())).toList();
    }

    public List<FakeStoreProductDTO> getAllProductsInCategory(String name) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO[]> response = restTemplate.getForEntity(productsInCategory, FakeStoreProductDTO[].class, name);
        return Arrays.stream(Objects.requireNonNull(response.getBody())).toList();
    }


}
