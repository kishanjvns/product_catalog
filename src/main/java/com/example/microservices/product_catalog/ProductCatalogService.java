package com.example.microservices.product_catalog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductCatalogService {
    
	 @Value("${server.url}")
	    private String url;
	 
    @Autowired
    private  ProductCatalogRepository productCatalogRepository;

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product){
        return productCatalogRepository.save(product);
    }

    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product){
        return productCatalogRepository.save(product);        
    }

    @GetMapping("/product/{id}")
    public Product getProductDetails(@PathVariable  String id){
    	System.out.println("server config value "+url);
        return productCatalogRepository.findById(id).get();
    }


    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable String id) {
        Product toDeleteProduct = new Product();
        toDeleteProduct.setId(id);

        productCatalogRepository.delete(toDeleteProduct);
        return "Product Deleted-"+id;
    }

    @GetMapping("/product")
    public List<Product> getProductList(){
        return (List<Product>) productCatalogRepository.findAll();
    }

}