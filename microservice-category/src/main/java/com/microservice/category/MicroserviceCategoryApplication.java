package com.microservice.category;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceCategoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCategoryApplication.class, args);
	}
	@Bean
	public CorsConfiguration corsConfiguration() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
		configuration.setAllowCredentials(true);
		configuration.setMaxAge(3600L);
		return configuration;
	}
}
