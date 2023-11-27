package com.codephety.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.codephety.app.*"})
public class SpringBootApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp.class, args);
	}

}
