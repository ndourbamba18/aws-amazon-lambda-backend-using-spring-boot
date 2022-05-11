package com.ndourcodeur.springbootawslambdademo.services;

import com.ndourcodeur.springbootawslambdademo.dto.ProductDto;
import com.ndourcodeur.springbootawslambdademo.entity.Product;
import com.ndourcodeur.springbootawslambdademo.exception.ResourceNotFoundException;
import com.ndourcodeur.springbootawslambdademo.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> findAllProducts() {
        log.info("findAllProduct Inside ProductService");
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(Long id) {
        log.info("findProductById Inside ProductService");
        return productRepository.findById(id).
                orElseThrow( () -> new ResourceNotFoundException("Product not found with ID:"+id));
    }

    @Override
    public Product addProduct(ProductDto dto) {
        log.info("addProduct Inside ProductService");
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setInStock(dto.isInStock());
        product.setDescription(dto.getDescription());
        product.setCreatedAt(dto.getCreatedAt());
        product.setUpdatedAt(dto.getUpdatedAt());
        product.setDeletedAt(dto.getDeletedAt());
        return productRepository.save(product);
    }

    @Override
    public Product editProductById(Long id, ProductDto dto) {
        log.info("editProductById Inside ProductService");
        Product existingProduct = productRepository.findById(id).
                orElseThrow( () -> new ResourceNotFoundException("Product not found with ID:"+id));
        existingProduct.setId(dto.getId());
        existingProduct.setName(dto.getName());
        existingProduct.setPrice(dto.getPrice());
        existingProduct.setInStock(dto.isInStock());
        existingProduct.setDescription(dto.getDescription());
        existingProduct.setCreatedAt(dto.getCreatedAt());
        existingProduct.setUpdatedAt(dto.getUpdatedAt());
        existingProduct.setDeletedAt(dto.getDeletedAt());
        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProductById(Long id) {
        log.info("deleteProductById Inside ProductService");
        Product existingProduct = productRepository.findById(id).
                orElseThrow( () -> new ResourceNotFoundException("Product not found with ID:"+id));
        productRepository.delete(existingProduct);
    }

    @Override
    public List<Product> searchPost(String keyword) {
        List<Product> searchProducts = productRepository.findByKeyword(keyword);
        return searchProducts;
    }
}
