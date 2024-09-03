package com.akash.productservicesnew.controllers.fakeStore;

import com.akash.productservicesnew.dtos.GenericProductDTO;
import com.akash.productservicesnew.exceptions.NotFoundException;
import com.akash.productservicesnew.services.fakeStoreService.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<GenericProductDTO>> getAllProducts() {
        List<GenericProductDTO> allProducts =productService.getAllProducts();
        if (allProducts.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericProductDTO> getProductById(@PathVariable("id") Long id) throws NotFoundException {
        GenericProductDTO genericProductDTO =productService.getProductById(id);
        if (genericProductDTO ==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(genericProductDTO, HttpStatus.OK);
    }

//    @GetMapping("/categories")
//    public List<String> getAllCategories() {
//        return productService.getAllCategories();
//    }

//    @GetMapping("/category/{name}")
//    public List<ProductDTO> getAllProductsInCategory(@PathVariable("name") String name) {
//        return productService.getAllProductsInCategory(name);
//    }


    @PostMapping()
    public GenericProductDTO addNewProduct(@RequestBody GenericProductDTO genericProductDTO) {
        return productService.addNewProduct(genericProductDTO);
    }

    @PutMapping("/{id}")
    public GenericProductDTO updateProduct(@RequestBody GenericProductDTO genericProductDTO, @PathVariable("id") Long id) throws NotFoundException {
        return productService.updateProduct(genericProductDTO, id);
    }

    @DeleteMapping("/{id}")
    public GenericProductDTO deleteProduct(@PathVariable("id") Long id) throws NotFoundException {
        return productService.deleteProduct(id);
    }
}
