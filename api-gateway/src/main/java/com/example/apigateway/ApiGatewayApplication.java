package com.example.apigateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import com.example.apigateway.Authfilter.authfilter;



@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

@Autowired
authfilter authfilte;

	@Bean
	public RouteLocator routesLocator(RouteLocatorBuilder builder) {
		
		OrderedGatewayFilter orderedGatewayFilter =
		new OrderedGatewayFilter(authfilte.apply(new authfilter.Config()), 0);
		
		return builder.routes()

				.route(p -> p.path("/user/**")
				.filters(f -> f.circuitBreaker(config -> config.setName("mycmd").setFallbackUri("forward:/fallback")).filter(orderedGatewayFilter))
				.uri("lb://USERSERVICECONFIG"))
				
				
				.route(p -> p.path("/posts/**")
				.filters(f -> f.circuitBreaker(config -> config.setName("mycmd").setFallbackUri("forward:/fallback")).filter(orderedGatewayFilter))
				.uri("lb://POSTSERVICECONFIG"))
				
				
				.route(p -> p.path("/com_like/**")
				.filters(f -> f.circuitBreaker(config -> config.setName("mycmd").setFallbackUri("forward:/fallback")).filter(orderedGatewayFilter))
				.uri("lb://LIKCOMMENTCONFIG"))


				.build();
	}




}