package com.cisse;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import com.cisse.entities.Facture;
import com.cisse.entities.ProductItem;
import com.cisse.externalElements.Customer;
import com.cisse.externalElements.CustomerRestTemplate;
import com.cisse.externalElements.Product;
import com.cisse.externalElements.ProductRestTemplate;
import com.cisse.repositories.FactureRepository;
import com.cisse.repositories.ProductItemRepository;


@EnableFeignClients //activer OPenfeign
@SpringBootApplication
public class ServiceFactureMs3Application {

	public static void main(String[] args) {
		SpringApplication.run(ServiceFactureMs3Application.class, args);
	}
	
	@Bean
	CommandLineRunner start(FactureRepository factureRepository ,
			ProductItemRepository productItemRepository,
			CustomerRestTemplate customerRestTemplate,
			ProductRestTemplate productRestTemplate) {
		return args->{
			
			Customer customerdto1 = customerRestTemplate.findCustomerById(1L);
			 System.out.println("*********DEBUT*********");
			 System.out.println("ID = " + customerdto1.getId() + 
					            "NOM = " + customerdto1.getName() +
					            "EMAIL = " + customerdto1.getEmail());
			 
			 System.out.println("*********FIN*********");
			 
			 Product p1 = productRestTemplate.findProductById(1L);
			 Product p2 = productRestTemplate.findProductById(2L);
			 Product p3 = productRestTemplate.findProductById(3L);
			 
			 
			 //Liste des produits
			 
			 PagedModel<Product> products=  productRestTemplate.findAllProducts();
			 products.getContent().stream().forEach(p->{
				 Facture facture1 =  factureRepository.save(new Facture(null,new Date(),customerdto1.getId(),null,null));
				 productItemRepository.save(new ProductItem(null,p.getId(),null,p1.getPrice(),30,facture1));
			 });
			 
			
		  
		
		};
	}
	
	

}
