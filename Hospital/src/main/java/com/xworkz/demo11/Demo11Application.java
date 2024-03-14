package com.xworkz.demo11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Hospital Open API",
				version = "1.0.0",
				description = "Hospital OPEN API documentation"
				),
		servers = @Server(
				url="http://localhost:9990",
				description = "Student OPEN API URL"
				)
		)
public class Demo11Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo11Application.class, args);
	}
}
