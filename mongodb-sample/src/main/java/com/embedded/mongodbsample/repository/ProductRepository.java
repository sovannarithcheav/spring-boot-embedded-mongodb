package com.embedded.mongodbsample.repository;

import com.embedded.mongodbsample.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String> {
}