package com.diegodenzer.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.diegodenzer.api.config.property.ApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(ApiProperty.class)
public class FinancasApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancasApiApplication.class, args);
	}
}
