package com.fatih.backend.CollecShare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(value=SpringBootRestProperties.class)
@SpringBootApplication
public class CollecShareApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CollecShareApplication.class, args);
	}
	
	

}
