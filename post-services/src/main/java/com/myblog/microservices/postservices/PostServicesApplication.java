package com.myblog.microservices.postservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PostServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostServicesApplication.class, args);
	}

}
