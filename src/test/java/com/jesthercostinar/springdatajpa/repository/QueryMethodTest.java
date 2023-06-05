package com.jesthercostinar.springdatajpa.repository;

import com.jesthercostinar.springdatajpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class QueryMethodTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByName() {
        Product product = productRepository.findByName("Product 7");

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findById() {
        Product product = productRepository.findById(12L).get();

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByNameAndDescription() {
        List<Product> products = productRepository.findByNameAndDescription("Product 7", "Product 7 description");

        products.forEach(p -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getDescription());
        });
    }

    @Test
    void findByNameOrDescription() {
        List<Product> products = productRepository.findByNameOrDescription("Product 8", "Product 11 description");

        products.forEach(p -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getDescription());
        });
    }

    @Test
    void findDistinctByNameMethod() {
        Product product = productRepository.findDistinctByName("Product 7");

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByPriceGreaterThanMethod() {
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(500));

        products.forEach(p -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getDescription());
        });
    }

    @Test
    void findByPriceLessThanMethod() {
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(900));

        products.forEach(p -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getDescription());
        });
    }

    @Test
    void findByNameContainingMethod() {
        List<Product> products = productRepository.findByNameContaining("8");

        products.forEach(p -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getDescription());
        });
    }

    @Test
    void findByNameLikeMethod() {
        List<Product> products = productRepository.findByNameLike("Product 8");

        products.forEach(p -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getDescription());
        });
    }

    @Test
    void findByPriceBetweenMethod() {
        List<Product> products = productRepository.findByPriceBetween(
                new BigDecimal(800),
                new BigDecimal(1000)
        );

        products.forEach(p -> {
            System.out.println(
                    "Id: " + p.getId() + " - " +
                    "Name: " + p.getName() + " - " +
                    "Description: " + p.getDescription()
            );
        });
    }

    @Test
    void findDateCreatedBetweenMethod() {
        LocalDateTime fromDate = LocalDateTime.of(2023, 06, 06, 03, 00, 00);
        LocalDateTime toDate = LocalDateTime.of(2023, 06, 06, 04, 00, 00);

        List<Product> products = productRepository.findByDateCreatedBetween(fromDate, toDate);

        products.forEach(p -> {
            System.out.println(
                    "Id: " + p.getId() + " - " +
                    "Name: " + p.getName() + " - " +
                    "Date Created: " + p.getDateCreated()
            );
        });
    }

    @Test
    void findByNameInMethod() {
        List<String> names = new ArrayList<>();
        names.add("Product 7");
        names.add("Product 8");

//        List<Product> products = productRepository.findByNameIn(names);
        List<Product> products = productRepository.findByNameIn(List.of("Product 8", "Product 9"));


        products.forEach(p -> {
            System.out.println(
                    "Id: " + p.getId() + " - " +
                    "Name: " + p.getName() + " - "
            );
        });
    }

    @Test
    void findFirst2ActiveOrderByNameAscMethod() {
        List<Product> products = productRepository.findFirst2ByActiveOrderByNameAsc(true);

        products.forEach(p -> {
            System.out.println(
                    "Id: " + p.getId() + " - " +
                    "Name: " + p.getName() + " - "
            );
        });
    }

    @Test
    void findTop3PriceOrderByAsc() {
        List<Product> products = productRepository.findTop3ByOrderByPriceDesc();

        products.forEach(p -> {
            System.out.println(
                    "Id: " + p.getId() + " - " +
                    "Name: " + p.getName() + " - " +
                    "Name: " + p.getPrice() + " - "
            );
        });
    }
}
