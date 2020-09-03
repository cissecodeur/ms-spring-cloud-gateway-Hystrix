package com.cisse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.cisse.entities.Product;
import com.cisse.repositories.ProductRepository;

@SpringBootApplication
public class ServiceProductMs2Application {

	public static void main(String[] args) {
		SpringApplication.run(ServiceProductMs2Application.class, args);
	}

	
	 @Bean
	 CommandLineRunner start(ProductRepository productRepository , RepositoryRestConfiguration restConfiguration) {
		 return args -> {
			 
			  restConfiguration.exposeIdsFor(Product.class);
			  productRepository.save(new Product(null,"Savon",250.0));
			  productRepository.save(new Product(null,"Ordinateur",25000.0));
			  productRepository.save(new Product(null,"Voiture",3555250.0));
			  
			  productRepository.findAll().forEach(System.out::println);
		 };
		 
	 }
}
