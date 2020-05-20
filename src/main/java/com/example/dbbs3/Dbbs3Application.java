package com.example.dbbs3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Dbbs3Application {

	public static void main(String[] args) {
		SpringApplication.run(Dbbs3Application.class, args);
	}

}
