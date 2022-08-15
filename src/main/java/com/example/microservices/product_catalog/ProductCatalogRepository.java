package com.example.microservices.product_catalog;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCatalogRepository extends CrudRepository<Product, String> {

}
