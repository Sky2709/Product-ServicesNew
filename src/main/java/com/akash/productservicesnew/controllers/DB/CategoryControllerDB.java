package com.akash.productservicesnew.controllers.DB;

import com.akash.productservicesnew.dtos.CategoryDTO;
import com.akash.productservicesnew.dtos.ProductDTO;
import com.akash.productservicesnew.models.Category;
import com.akash.productservicesnew.services.DB.CategoryServiceDB;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DB/categories")
public class CategoryControllerDB {
    private final CategoryServiceDB categoryServiceDB;

    public CategoryControllerDB(CategoryServiceDB categoryServiceDB) {
        this.categoryServiceDB = categoryServiceDB;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        return ResponseEntity.ok(categoryServiceDB.getAllCategories());
    }

    @GetMapping("/{categoryUUID}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable String categoryUUID) {
        return ResponseEntity.ok(categoryServiceDB.getCategory(categoryUUID));
    }

    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDTO categoryDTO) {
        return ResponseEntity.ok(categoryServiceDB.createCategory(categoryDTO));
    }


    @GetMapping("/products/{categoryUUID}")
    public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable String categoryUUID) {
        return ResponseEntity.ok(categoryServiceDB.getProductsByCategory(categoryUUID));
    }

    @GetMapping("/categoryName/{categoryUUID}")
    public ResponseEntity<String> getCategoryNameById(@PathVariable String categoryUUID) {
        return ResponseEntity.ok(categoryServiceDB.getCategoryNameById(categoryUUID));
    }

    @GetMapping("/productsName/{categoryUUID}")
    public ResponseEntity<List<String>> getProductsNameByCategoryId(@PathVariable String categoryUUID) {
        return ResponseEntity.ok(categoryServiceDB.getProductsNameByCategoryId(categoryUUID));
    }


}
