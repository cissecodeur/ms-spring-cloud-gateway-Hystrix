package com.cisse.externalElements;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "SERVICE-PRODUCTMS2")
public interface ProductRestTemplate {
	
	@GetMapping("/products/{id}")
	public Product findProductById(@PathVariable(name="id")Long id);
	
	
	// Gestion de la deserialisation des objets Hateos
	@GetMapping("/products")
	public PagedModel<Product>   findAllProducts();

}
