package com.example.microservices.repo;

import com.example.microservices.domain.Product;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ProductSpecificationBuilder {
    private final List<SearchCriteria> params;

    public ProductSpecificationBuilder() {
        this.params = new ArrayList<>();
    }

    public final ProductSpecificationBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public final ProductSpecificationBuilder with(SearchCriteria searchCriteria) {
        params.add(searchCriteria);
        return this;
    }

    public Specification<Product> build() {
        if (params.size() == 0) {
            return null;
        }
        Specification<Product> result = new ProductSpecification(params.get(0));
        for (int idx = 1; idx < params.size(); idx++) {
            SearchCriteria criteria = params.get(idx);
            result = SearchOperation.getDataOption(criteria.getDataOption()) == SearchOperation.ALL ? Specification.where(result).and(new ProductSpecification(criteria)) : Specification.where(result).or(new ProductSpecification(criteria));
        }
        return result;
    }

}
