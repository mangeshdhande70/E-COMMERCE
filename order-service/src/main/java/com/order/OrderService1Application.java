package com.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EntityScan("ecommerce.object_jars.entity")
public class OrderService1Application {

	public static void main(String[] args) {
		SpringApplication.run(OrderService1Application.class, args);
	}

}
