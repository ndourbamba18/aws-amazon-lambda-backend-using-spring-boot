package com.ndourcodeur.springbootawslambdademo.seeder;

import com.github.javafaker.Faker;
import com.ndourcodeur.springbootawslambdademo.entity.Product;
import com.ndourcodeur.springbootawslambdademo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
public class DatabaseTableSeeder implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    public static Faker faker = new Faker();

    @Override
    public void run(String... args) throws Exception {
        ProductTableSeeder();
    }

    private void ProductTableSeeder() {
        if (this.productRepository.findAll().isEmpty()) {

            for (int i=0; i < 10; i++) {
                Random random = new Random();
                Product product = new Product
                        (       null,
                                faker.commerce().productName(),
                                faker.commerce().price(),
                                true,
                                faker.lorem().paragraph(),
                                faker.date().birthday(),
                                faker.date().birthday(),
                                faker.date().birthday()

                        );
                this.productRepository.save(product);
            }
        }
    }

}
