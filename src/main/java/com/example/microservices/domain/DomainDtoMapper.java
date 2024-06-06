package com.example.microservices.domain;

import com.example.microservices.dto.ProductDto;

public class DomainDtoMapper {
    public static Product getProduct(ProductDto productDto) {
        return Product.builder()
                .price(productDto.getPrice())
                .desc(productDto.getDesc())
                .title(productDto.getTitle())
                .createdDate(productDto.getCreatedDate())
                .build();
    }

    public static ProductDto getProductDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .price(product.getPrice())
                .desc(product.getDesc())
                .title(product.getTitle())
                .createdDate(product.getCreatedDate())
                .build();
    }
}
