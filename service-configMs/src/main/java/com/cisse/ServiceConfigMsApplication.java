package com.cisse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer // pour activer la config des microservices
@SpringBootApplication
public class ServiceConfigMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceConfigMsApplication.class, args);
	}

}
