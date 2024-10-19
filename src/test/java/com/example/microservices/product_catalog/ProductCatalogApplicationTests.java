package com.example.microservices;

import com.example.microservices.domain.Product;
import com.example.microservices.repo.ProductRepository;
import com.example.microservices.repo.SearchCriteria;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ProductCatalogApplicationTests {
    @Autowired
    ProductRepository productRepository;

    @BeforeEach
    public void  init(){
        List<Product> products=new ArrayList<>();
        products.add(Product.builder()
                .createdDate(LocalDate.now())
                .title("11 Rules of life")
                .desc("for life changing")
                .price(250)
                .build());
        products.add(Product.builder()
                .createdDate(LocalDate.now())
                .title("Modern parenting")
                .desc("for new parents")
                .price(350)
                .build());
        products.add(Product.builder()
                .createdDate(LocalDate.now())
                .title("Ravana")
                .desc("Dharmik")
                .price(990)
                .build());
        products.add(Product.builder()
                .createdDate(LocalDate.now())
                .title("Java 11")
                .desc("Technology")
                .price(1000)
                .build());

        productRepository.saveAll(products);
    }

    @Test
    public void isRecordAvailable(){
        List<Product> products = productRepository.findAll();
        Assert.notEmpty(products,"This is not null");
    }

}
