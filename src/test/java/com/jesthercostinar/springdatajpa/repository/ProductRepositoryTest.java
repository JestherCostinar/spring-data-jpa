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
        product.setName("Product to delete");
        product.setDescription("Product to delete description");
        product.setSku("500abc");
        product.setPrice(new BigDecimal(500));
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
        product2.setName("Product 8");
        product2.setDescription("Product 8 description");
        product2.setSku("800abc");
        product2.setPrice(new BigDecimal(800));
        product2.setActive(true);
        product2.setImageUrl("product-image.jpg");

        Product product3 = new Product();
        product3.setName("Product 9");
        product3.setDescription("Product 9 description");
        product3.setSku("900abc");
        product3.setPrice(new BigDecimal(900));
        product3.setActive(true);
        product3.setImageUrl("product-image.jpg");

        Product product4 = new Product();
        product4.setName("Product 10");
        product4.setDescription("Product 10 description");
        product4.setSku("1000abc");
        product4.setPrice(new BigDecimal(1000));
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

    // Delete entity using deleteById Method()
    @Test
    void deleteById() {
        Long id = 8L;
        productRepository.deleteById(id);
    }

    // Delete entity by  All the entity information using delete method()
    @Test
    void deleteMethod() {
        // find an entity by id first
        Long id = 7L;
        Product product = productRepository.findById(id).get();

        // delete the entity using the retrieve id
        productRepository.delete(product);
    }

    // Delete all entity by providing the list of entities to delete using deleteAll() method
    // Delete all - If the parameter is not supply, all the entity inside the repository will be deleted
    @Test
    void deleteAll() {
        // This will delete all the entity in the product repository because the parameter is not supply
        productRepository.deleteAll();

        // This will delete all the entity that is supplied in the parameter
        Product product1 = productRepository.findById(10L).get();
        Product product2 = productRepository.findById(11L).get();
        Product product3 = productRepository.findById(12L).get();

        productRepository.deleteAll(List.of(product1, product2));
    }

    // Count how many records in the repository
    @Test
    void countMethod() {
        long count = productRepository.count();
        System.out.println(count);
    }

    // Check if the entity is exist in the record or not using the existById() method

    @Test
    void existById() {
        Long id = 12L;
        boolean isProductExist = productRepository.existsById(id);
        System.out.println(isProductExist);
    }
}