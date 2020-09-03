package com.cisse.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.cisse.externalElements.Customer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Facture implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dateFacture;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private Long idCustomer;
	@Transient //Pour en pas persiter cette attribut en base
	private Customer customer;
	
	@OneToMany(mappedBy = "facture")
	private Collection<ProductItem>  productItems;
	

}
