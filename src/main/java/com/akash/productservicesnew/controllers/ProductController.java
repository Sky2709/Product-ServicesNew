package com.akash.productservicesnew.controllers;

import com.akash.productservicesnew.dtos.ProductDTO;
import com.akash.productservicesnew.exceptions.NotFoundException;
import com.akash.productservicesnew.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> allProducts =productService.getAllProducts();
        if (allProducts.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Long id) throws NotFoundException {
        ProductDTO productDTO=productService.getProductById(id);
        if (productDTO==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
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
    public ProductDTO addNewProduct(@RequestBody ProductDTO productDTO) {
        return productService.addNewProduct(productDTO);
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO, @PathVariable("id") Long id) throws NotFoundException {
        return productService.updateProduct(productDTO, id);
    }

    @DeleteMapping("/{id}")
    public ProductDTO deleteProduct(@PathVariable("id") Long id) throws NotFoundException {
        return productService.deleteProduct(id);
    }
}
