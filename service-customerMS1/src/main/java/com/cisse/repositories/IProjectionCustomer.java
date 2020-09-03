package com.cisse.repositories;

import org.springframework.data.rest.core.config.Projection;

import com.cisse.entities.Customer;

//Interface pour filtrer le retour json(HATEOAS)

@Projection(name="customerProjection" , types = Customer.class)
public interface IProjectionCustomer {
	
	public Long getId();
	public String getName();
	

}
