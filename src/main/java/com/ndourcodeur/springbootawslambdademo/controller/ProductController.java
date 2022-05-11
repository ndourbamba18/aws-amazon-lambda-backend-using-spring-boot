package com.ndourcodeur.springbootawslambdademo.controller;

import com.ndourcodeur.springbootawslambdademo.dto.ProductDto;
import com.ndourcodeur.springbootawslambdademo.entity.Product;
import com.ndourcodeur.springbootawslambdademo.message.Message;
import com.ndourcodeur.springbootawslambdademo.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/products")
@CrossOrigin(origins = "*")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;


    /**
     *   URL ====> http://localhost:8080/api/v1/products
     */
    @GetMapping()
    public ResponseEntity<?> getAllProducts(){
        log.info("getAllProducts Inside ProductController");
        List<Product> products = productService.findAllProducts();
        if (products.isEmpty())
            return new ResponseEntity<>(new Message("No Content :("), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


    /**
     *   URL ====> http://localhost:8080/api/v1/products/{id}
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id){
        log.info("getProductById Inside ProductController");
        Product product = productService.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    /**
     *   URL ====> http://localhost:8080/api/v1/products
     */
    @PostMapping()
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductDto dto){
        log.info("createProduct Inside ProductController");
        Product product = productService.addProduct(dto);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }


    /**
     *   URL ====> http://localhost:8080/api/v1/products/{id}
     */
    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateProductById(@PathVariable Long id, @Valid @RequestBody ProductDto dto){
        log.info("updateProductById Inside ProductController");
        Product product = productService.editProductById(id, dto);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    /**
     *   URL ====> http://localhost:8080/api/v1/products/{id}
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable Long id){
        log.info("deleteProductById Inside ProductController");
        productService.deleteProductById(id);
        return new ResponseEntity<>(new Message("Product deleted successfully with ID:"+id), HttpStatus.OK);
    }

    /**
     *   URL ===>  http://localhost:8080/api/v1/products/search/{keyword}
     */
    @GetMapping(path = "/search/{keyword}")
    public ResponseEntity<?> searchPostByKeyword(@PathVariable("keyword") String keyword){
        List<Product> searchAllProducts = productService.searchPost(keyword);
        if (searchAllProducts.isEmpty())
            return new ResponseEntity<>(new Message("Sorry, No Product available!"), HttpStatus.BAD_GATEWAY);
        return new ResponseEntity<>(searchAllProducts, HttpStatus.OK);
    }
}
