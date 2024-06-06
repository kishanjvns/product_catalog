package com.example.microservices.repo;

import com.example.microservices.domain.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Objects;

public class ProductSpecification implements Specification<Product> {
    private final SearchCriteria searchCriteria;

    public ProductSpecification(final SearchCriteria searchCriteria){
        super();
        this.searchCriteria = searchCriteria;
    }
    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        String strToSearch = searchCriteria.getValue().toString().toLowerCase();
        Predicate predicate = null;
        switch (Objects.requireNonNull(SearchOperation.getSimpleOperation(searchCriteria.getOperation()))) {
            case EQUAL:
                predicate= cb.equal(cb.lower(root.get(searchCriteria.getFilterKey())),strToSearch);
                break;
            case CONTAINS:
                predicate= cb.like(cb.lower(root.get(searchCriteria.getFilterKey())), "%" + strToSearch + "%");
                break;
            case DOES_NOT_CONTAIN:
                predicate= cb.notLike(cb.lower(root.get(searchCriteria.getFilterKey())), "%" + strToSearch + "%");
                break;

        }
        return predicate;
    }
    /*private Join<Employee,Department> departmentJoin(Root<Employee>
                                                             root){
        return root.join("department");
    }*/
    }