package com.cisse.externalElements;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "SERVICE-CUSTOMERMS1")
public interface CustomerRestTemplate {
	
	//Ce customer ira communiquer avec le Customer du service Externe
	// Feign est utilisé pour consommer un service externe,il reagit comme restTemplate
	
	@GetMapping("/customers/{id}")
	public Customer findCustomerById(@PathVariable(name="id") Long id);

}
