package com.assignment.primenumbers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class PrimenumbersApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimenumbersApplication.class, args);
	}

}
