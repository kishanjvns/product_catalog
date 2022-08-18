package com.example.microservices.product_catalog;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

	@Bean(name = "restTemplate")
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean(name = "loadBalancedRestTemplate")
	@LoadBalanced
	RestTemplate loadBalancedRestTemplate() {
		return new RestTemplate();
	}
}
