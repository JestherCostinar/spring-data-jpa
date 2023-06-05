package com.jesthercostinar.springdatajpa.repository;

import com.jesthercostinar.springdatajpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Refer to this link for the query keyword for creating hibernate query: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
    // Custom Query method converted to jpa query via hibernate


    // This is return the product entity that match the name

    /**
     * Returns a Product base on name
     * @param name
     * @return
     */
    Product findByName(String name);

    /**
     * Return a Product base on ID
     * @param id
     * @return
     */
    Optional<Product> findById(Long id);

    /**
     * Return a list of product base on name AND description
     * @param name
     * @param description
     * @return
     */
    List<Product> findByNameAndDescription(String name, String description);

    /**
     * Return a list of Product base on name OR description
     * @param name
     * @param description
     * @return
     */
    List<Product> findByNameOrDescription(String name, String description);

    /**
     * Return unique/distinct product base of name
     * @param name
     * @return
     */
    Product findDistinctByName(String name);

    /**
     * Return a list of product that is greater than the @param price
     * @param price
     * @return
     */
    List<Product> findByPriceGreaterThan(BigDecimal price);

    /**
     * Return a list of product that is less than the @param price
     * @param price
     * @return
     */
    List<Product> findByPriceLessThan(BigDecimal price);

    /**
     * Return list of product that contains the name in product name
     * @param name
     * @return
     */
    List<Product> findByNameContaining(String name);

    /**
     * Return a list of product whose name like parameter name
     * @param name
     * @return
     */
    List<Product> findByNameLike(String name);

    /**
     * Return a list of product that the price is between @param fromPrice and @param toPrice
     * @param fromPrice
     * @param toPrice
     * @return
     */
    List<Product> findByPriceBetween(BigDecimal fromPrice, BigDecimal toPrice);

    /**
     * Return list of product that the dateCreated is between the @param fromDate and @param toDate
     * @param fromDate
     * @param toDate
     * @return
     */
    List<Product> findByDateCreatedBetween(LocalDateTime fromDate, LocalDateTime toDate);

    /**
     * Return list of product that is IN the list of name (array name)
     * @param name
     * @return
     */
    List<Product> findByNameIn(List<String> name);

    /**
     * Return first 2 record from product that is active and the result is in ascending order
     * @param isActive
     * @return
     */
    List<Product> findFirst2ByActiveOrderByNameAsc(Boolean isActive);

    /**
     * Return top 3 product base on price and the result is in descending order
     * @return
     */
    List<Product> findTop3ByOrderByPriceDesc();
}
