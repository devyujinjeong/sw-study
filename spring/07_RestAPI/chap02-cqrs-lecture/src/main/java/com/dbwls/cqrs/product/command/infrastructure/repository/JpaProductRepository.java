package com.dbwls.cqrs.product.command.infrastructure.repository;

import com.dbwls.cqrs.product.command.domain.aggeregate.Product;
import com.dbwls.cqrs.product.command.domain.repository.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends ProductRepository, JpaRepository<Product, Long> {


}
