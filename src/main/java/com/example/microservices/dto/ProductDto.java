package com.example.microservices.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@Data
@Setter
@Getter
public class ProductDto {
    private Long id;
    private String title;
    private String desc;
    private LocalDate createdDate;
    private double price;
    public ProductDto(){}
}
