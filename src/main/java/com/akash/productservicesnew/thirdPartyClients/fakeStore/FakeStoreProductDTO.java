package com.akash.productservicesnew.thirdPartyClients.fakeStore;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FakeStoreProductDTO {
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;


}
