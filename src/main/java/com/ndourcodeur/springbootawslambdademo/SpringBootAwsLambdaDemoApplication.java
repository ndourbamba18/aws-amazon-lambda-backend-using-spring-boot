package com.ndourcodeur.springbootawslambdademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootAwsLambdaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAwsLambdaDemoApplication.class, args);

		System.out.println("Server is running.....");
	}

}
