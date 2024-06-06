package com.example.microservices;

import com.example.microservices.domain.DomainDtoMapper;
import com.example.microservices.domain.Product;
import com.example.microservices.dto.APIResponse;
import com.example.microservices.dto.ProductDto;
import com.example.microservices.dto.ProductSearchDto;
import com.example.microservices.repo.ProductSpecificationBuilder;
import com.example.microservices.repo.SearchCriteria;
import com.example.microservices.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping()
    public ResponseEntity saveProduct(@RequestBody ProductDto productDto){

        productService.addEmployee(productDto);
        return ResponseEntity.ok().build();

    }
    @PostMapping("/batch")
    public ResponseEntity saveProducts(@RequestBody List<ProductDto> productDtos){
        List<ProductDto> saved=  productService.addEmployee(productDtos);
        return ResponseEntity.ok().build();

    }
    @PostMapping("/search")
    public ResponseEntity<APIResponse> searchEmployees(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum, @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
             @RequestBody ProductSearchDto productSearchDto){
        APIResponse apiResponse = new APIResponse();
        ProductSpecificationBuilder builder = new ProductSpecificationBuilder();
        List<SearchCriteria> criteriaList = productSearchDto.getSearchCriteriaList();
        if(criteriaList != null){
            criteriaList.forEach(searchCrit-> {
                searchCrit.setDataOption(productSearchDto.getDataOption());
                builder.with(searchCrit);
            });
        }

        Pageable page = PageRequest.of(pageNum, pageSize, Sort.by("title")
                        .ascending()
                        .and(Sort.by("price"))
                        .ascending()
                        .and(Sort.by("createdDate"))
                        .ascending());

        Page<Product> employeePage = productService  .findBySearchCriteria(builder.build(), page);
        List<ProductDto> productDtos = employeePage.stream().map(p-> DomainDtoMapper.getProductDto(p)).collect(Collectors.toList());
        apiResponse.setData(productDtos);
        apiResponse.setResponseCode(HttpStatus.OK);
        apiResponse.setMessage("Successfully retrieved employee record");

        return new ResponseEntity<>(apiResponse,
                apiResponse.getResponseCode());
    }
}
