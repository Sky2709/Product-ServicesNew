package com.akash.productservicesnew.controllers.DB;

import com.akash.productservicesnew.dtos.ProductDTO;
import com.akash.productservicesnew.services.DB.ProductServiceDB;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/DB/products")
public class ProductControllerDB {
    private final ProductServiceDB productServiceDB;

    public ProductControllerDB(ProductServiceDB productServiceDB) {
        this.productServiceDB = productServiceDB;
    }

    @GetMapping()
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productServiceDB.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable String id) {
        return ResponseEntity.ok(productServiceDB.getProductById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable String id) {
        productServiceDB.deleteProductById(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

    @PostMapping("/add")
    public ResponseEntity<String> addNewProduct(@RequestBody ProductDTO productDTO) {
        productServiceDB.addNewProduct(productDTO);
        return ResponseEntity.ok("Product added successfully");
    }

    @PostMapping("/add/{categoryId}")
    public ResponseEntity<String> addNewProductToCategory(@RequestBody ProductDTO productDTO, @PathVariable String categoryId) {
        productServiceDB.addNewProductToCategory(productDTO, UUID.fromString(categoryId));
        return ResponseEntity.ok("Product added to category successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProductTitle(@PathVariable String id, @RequestBody String newTitle) {
        productServiceDB.updateProductTitle(id, newTitle);
        return ResponseEntity.ok("Product title updated successfully");
    }
}
