package com.example.microservices.dto;

import com.example.microservices.repo.SearchCriteria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSearchDto {

    private List<SearchCriteria> searchCriteriaList;
    private String dataOption;

}
