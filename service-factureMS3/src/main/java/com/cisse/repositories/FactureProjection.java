package com.cisse.repositories;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

import com.cisse.entities.Facture;
import com.cisse.entities.ProductItem;

@Projection(name = "toutLesElements" , types = Facture.class)
public interface FactureProjection {
	
	public  Long getId();
	public  Date getDateFacture();
	public  Long getIdClient();
	public Collection<ProductItem> getProductItems();
	

}
