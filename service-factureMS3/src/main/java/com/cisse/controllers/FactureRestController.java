package com.cisse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cisse.entities.Facture;
import com.cisse.entities.ProductItem;
import com.cisse.externalElements.CustomerRestTemplate;
import com.cisse.externalElements.ProductRestTemplate;
import com.cisse.repositories.FactureRepository;
import com.cisse.repositories.ProductItemRepository;

@RestController
public class FactureRestController {
	
	@Autowired
	private FactureRepository factureRepository;
	@Autowired
	private ProductItemRepository productItemRepository;
	
	@Autowired
	private CustomerRestTemplate customerRestTemplate;
	@Autowired
	private ProductRestTemplate productRestTemplate;
	
	
	@GetMapping("/factures/{id}")
	public Facture GetFacture(@PathVariable(name="id")Long id) {
		Facture facture = factureRepository.findById(id).get();
		facture.setCustomer(customerRestTemplate.findCustomerById(facture.getIdCustomer()));
		
		facture.getProductItems().forEach(PI->{
			PI.setProduct(productRestTemplate.findProductById(PI.getProductId()));
		});
		return facture;
	}

}
