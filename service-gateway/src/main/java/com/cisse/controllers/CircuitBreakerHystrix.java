package com.cisse.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerHystrix {
	
	@GetMapping("/defaultCountries")
	public Map<String, String> countries(){
		
	     Map <String, String>	dataHystrix = new HashMap<>();
	            dataHystrix.put("message"," default countries");
	            dataHystrix.put("countries","Cote d'Ivoire,Senegal,Mali");
	            return dataHystrix;
	}
	 
     

}
