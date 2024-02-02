package com.example.articulate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ArticulateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArticulateApplication.class, args);
	}

}
