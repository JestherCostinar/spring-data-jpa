package com.jesthercostinar.springdatajpa.repository;

import com.jesthercostinar.springdatajpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        // Create product
        Product product = new Product();
        product.setName("Product 1");
        product.setDescription("Product 1 description");
        product.setSku("100abc");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product-image.jpg");

        // Save product using save() method
        Product saveProduct = productRepository.save(product);

        // Display product information
        System.out.println(saveProduct.getId());
        System.out.println(saveProduct.toString());
    }
}