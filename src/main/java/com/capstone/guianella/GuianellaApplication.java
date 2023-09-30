package com.capstone.guianella;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class GuianellaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuianellaApplication.class, args);
	}

}
