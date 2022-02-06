package com.sigabem.calculafrete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CalculafreteApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculafreteApiApplication.class, args);
	}

}
