package com.cisse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.cisse.entities.Customer;
import com.cisse.repositories.CustomerRepository;

@EnableDiscoveryClient //// activer la publication de la reference de notre microservice dans l'annuaire Eureka
@SpringBootApplication
public class ServiceCustomerMsApplication  {


	public static void main(String[] args) {
		SpringApplication.run(ServiceCustomerMsApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository , RepositoryRestConfiguration restConfiguration){
		
		return args ->{
			 restConfiguration.exposeIdsFor(Customer.class);
			 customerRepository.save(new Customer(null,"cisse","yacoub@mail.com"));
			 customerRepository.save(new Customer(null,"Kone","kone@mail.com"));
			 customerRepository.save(new Customer(null,"Kassi","Kass@mail.com"));
			 customerRepository.findAll().forEach(System.out::println);
			
		};
	
		
	}

}
