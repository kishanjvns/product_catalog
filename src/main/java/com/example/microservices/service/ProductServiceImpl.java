package com.example.microservices.service;

import com.example.microservices.domain.DomainDtoMapper;
import com.example.microservices.domain.Product;
import com.example.microservices.dto.ProductDto;
import com.example.microservices.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDto addEmployee(ProductDto ProductDto){
        Product emp = DomainDtoMapper.getProduct(ProductDto);
        return DomainDtoMapper.
                getProductDto(productRepository.saveAndFlush(emp));
    }
    @Override
    public List<ProductDto> addEmployee(List<ProductDto> ProductDtos){
        List<Product> products = ProductDtos.stream().map(dto-> DomainDtoMapper.getProduct(dto)).collect(Collectors.toList());
        List<Product> saved= productRepository.saveAll(products);
        return saved.stream().map(entity-> DomainDtoMapper.getProductDto(entity)).collect(Collectors.toList());
    }

    @Override
    public List<Product> findAllEmployee(){
        return productRepository.findAll();
    }

    @Override
    public Page<Product> findBySearchCriteria(Specification<Product> spec, Pageable page){
        Page<Product> searchResult = productRepository.findAll(spec,
                page);
        return searchResult;
    }
}
