package com.jesthercostinar.springdatajpa.repository;

import com.jesthercostinar.springdatajpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    // Save() method to save product entity to product table
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

    // Update using save() method to update product entity via ID
    @Test
    void updateUsingSaveMethod() {
        // find or retrieve an entity by id
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        // update entity information
        product.setName("update product 1");
        product.setDescription("updated product 1 description");

        // save updated entity
        productRepository.save(product);
    }

    // Retrive entity base on given id
    @Test
    void retrieveUsingFindById() {
        Long id = 1L;

        Product product = productRepository.findById(id).get();
    }

    // Save multiple entity using saveAll() method
    @Test
    void saveMultipleEntity() {
        // Create multiple product entity
        Product product2 = new Product();
        product2.setName("Product 2");
        product2.setDescription("Product 2 description");
        product2.setSku("200abc");
        product2.setPrice(new BigDecimal(200));
        product2.setActive(true);
        product2.setImageUrl("product-image.jpg");

        Product product3 = new Product();
        product3.setName("Product 3");
        product3.setDescription("Product 3 description");
        product3.setSku("300abc");
        product3.setPrice(new BigDecimal(300));
        product3.setActive(true);
        product3.setImageUrl("product-image.jpg");

        Product product4 = new Product();
        product4.setName("Product 4");
        product4.setDescription("Product 4 description");
        product4.setSku("400abc");
        product4.setPrice(new BigDecimal(400));
        product4.setActive(true);
        product4.setImageUrl("product-image.jpg");

        // Save multiple entity
        productRepository.saveAll(List.of(product2, product3, product4));
    }

    // Retrieve all entity using findAllMethod()
    @Test
    void findAllMethod() {
        List<Product> products = productRepository.findAll();
        products.forEach(p -> {
            System.out.println(p.getName());
        });
    }
}