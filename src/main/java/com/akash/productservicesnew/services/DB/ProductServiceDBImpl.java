package com.akash.productservicesnew.services.DB;

import com.akash.productservicesnew.dtos.ProductDTO;
import com.akash.productservicesnew.models.Category;
import com.akash.productservicesnew.models.Price;
import com.akash.productservicesnew.models.Product;
import com.akash.productservicesnew.repositories.CategoryRepository;
import com.akash.productservicesnew.repositories.PriceRepository;
import com.akash.productservicesnew.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceDBImpl implements ProductServiceDB {
    private final ProductRepository productRepository;
    private final PriceRepository priceRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceDBImpl(ProductRepository productRepository,
                                PriceRepository priceRepository,
                                CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return Optional.of(products)
                .orElse(List.of())
                .stream()
                .map(this::convertProductToProductDTO)
                .toList();
    }

    @Override
    public ProductDTO getProductById(String id) {
        Optional<Product> productOptional = productRepository.findById(UUID.fromString(id));
        if (productOptional.isEmpty()) {
            return null;
        }
        Product product = productOptional.get();
        return convertProductToProductDTO(product);
    }

    @Override
    @Transactional //
    public void deleteProductById(String id) {
        productRepository.deleteById(UUID.fromString(id));
    }

    @Override
    public void addNewProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setTitle(productDTO.getTitle());
        product.setDescription(productDTO.getDescription());
        product.setImage(productDTO.getImage());

        Category category=productDTO.getCategory();
        if (category.getId()==null || !categoryRepository.existsById(category.getId())) {
            categoryRepository.save(category);
        }
        product.setCategory(category);

        Price price=productDTO.getPrice();
        priceRepository.save(price);

        product.setPrice(price);
        productRepository.save(product);
    }

    @Override
    public void addNewProductToCategory(ProductDTO productDTO, UUID categoryId) {
        Product product = new Product();
        Category category = categoryRepository.findById(categoryId).orElseThrow();
        product.setTitle(productDTO.getTitle());
        product.setDescription(category.getName());
        product.setImage(productDTO.getImage());

        product.setCategory(category);

        Price price=productDTO.getPrice();
        priceRepository.save(price);
        product.setPrice(price);
        productRepository.save(product);
    }

    @Override
    public void updateProductTitle(String id, String newTitle) {
        Product product = productRepository.findById(UUID.fromString(id))
                                           .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setTitle(newTitle);
        productRepository.save(product);
    }

    private ProductDTO convertProductToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setTitle(product.getTitle());
        productDTO.setDescription(product.getDescription());
        productDTO.setImage(product.getImage());
        productDTO.setCategory(product.getCategory());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }
}
