package com.jesthercostinar.springdatajpa.repository;

import com.jesthercostinar.springdatajpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Refer to this link for the query keywork for creating hibernate query: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
    // Custom Query method converted to jpa query via hibernate


    // This is return the product entity that match the name
    Product findByName(String name);

    Optional<Product> findById(Long id);

    List<Product> findByNameAndDescription(String name, String description);

    List<Product> findByNameOrDescription(String name, String description);

    Product findDistinctByName(String name);

    List<Product> findByPriceGreaterThan(BigDecimal price);
    List<Product> findByPriceLessThan(BigDecimal price);

    List<Product> findByNameContaining(String name);
    List<Product> findByNameLike(String name);

    List<Product> findByPriceBetween(BigDecimal fromPrice, BigDecimal toPrice);

    List<Product> findByDateCreatedBetween(LocalDateTime fromDate, LocalDateTime toDate);

    List<Product> findByNameIn(List<String> name);

    List<Product> findFirst2ByActiveOrderByNameAsc(Boolean isActive);

    List<Product> findTop3ByOrderByPriceDesc();
}
