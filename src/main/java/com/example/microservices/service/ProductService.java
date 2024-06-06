package com.example.microservices.service;

import com.example.microservices.domain.Product;
import com.example.microservices.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ProductService {
    ProductDto addEmployee(ProductDto ProductDto);

    List<ProductDto> addEmployee(List<ProductDto> ProductDtos);

    List<Product> findAllEmployee();

    Page<Product> findBySearchCriteria(Specification<Product> spec, Pageable page);
}
