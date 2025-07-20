package com.dbwls.cqrs.product.command.domain.repository;

import com.dbwls.cqrs.product.command.domain.aggeregate.Product;

import java.util.Optional;

public interface ProductRepository {

    Product save(Product product);

    Optional<Product> findById(Long productCode);

    void deleteById(Long productCode);

}
