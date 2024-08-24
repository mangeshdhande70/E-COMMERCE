package com.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EntityScan("ecommerce.object_jars.entity")
public class CustomerService1Application {

	public static void main(String[] args) {
		SpringApplication.run(CustomerService1Application.class, args);
	}

}
