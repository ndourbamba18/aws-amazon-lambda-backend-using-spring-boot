package com.ndourcodeur.springbootawslambdademo.services;

import com.ndourcodeur.springbootawslambdademo.dto.ProductDto;
import com.ndourcodeur.springbootawslambdademo.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    public List<Product> findAllProducts();
    public Product findProductById(Long id);
    public Product addProduct(ProductDto dto);
    public Product editProductById(Long id, ProductDto dto);
    public void deleteProductById(Long id);
    public List<Product> searchPost(String keyword);
}
