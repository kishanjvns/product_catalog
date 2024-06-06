package com.example.microservices.dto;

import com.example.microservices.domain.Product;
import org.springframework.http.HttpStatus;

import java.util.List;

public class APIResponse {
    private List<ProductDto> productDtos;
    private HttpStatus responseCode;
    private String message;
    public void setData(List<ProductDto> list) {
        this.productDtos = list;
    }
    public void setResponseCode(HttpStatus responseCode){
        this.responseCode = responseCode;
    }
    public void setMessage(String  message){
        this.message =message;
    }

    public List<ProductDto> getProductDtos() {
        return productDtos;
    }

    public HttpStatus getResponseCode() {
        return responseCode;
    }

    public String getMessage() {
        return message;
    }
}
