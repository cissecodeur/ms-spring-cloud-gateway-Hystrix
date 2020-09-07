package com.cisse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableHystrix //Activer les dasboard Hystrix
@EnableDiscoveryClient
public class ServiceGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceGatewayApplication.class, args);
	}
	
	// Routage statics des urls via notre gateway avec les des MS dans l'annuaire
	@Bean
	RouteLocator StaticRoutes(RouteLocatorBuilder routeLocatorBuilder) {
		return routeLocatorBuilder.routes()
				    .route(r->r
				    		   .path("/publicCountries/**")
				    		   .filters(f->f
				    				   .addRequestHeader("X-RapidAPI-Host","restcountries-v1.p.rapidapi.com")
				    				   .addRequestHeader("X-RapidAPI-Key","8d19f08420msh3237396d913c536p1abc5djsn68e178b677c4")
				    		           .rewritePath("publicCountries/(?<segment>.*)","/${segment}")
				    				   .hystrix(hyst->hyst.setName("countries").setFallbackUri("forward://defaultCountries"))
				    		   )	    		           
				               .uri("https://restcountries-v1.p.rapidapi.com")
				    		   .id("r1")).build();
//				    
//				    .route(r->r.path("/products/**").uri("lb://SERVICE-PRODUCTMS2").id("r2"))
//				    .build();
	}
	

	// Routage dynamic des urls via notre gateway avec les des MS dans l'annuaire
	@Bean
	DiscoveryClientRouteDefinitionLocator dynamiqueRoute(ReactiveDiscoveryClient discoveryClient, DiscoveryLocatorProperties properties) {
		return new DiscoveryClientRouteDefinitionLocator(discoveryClient, properties);
	}

}
