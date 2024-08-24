package com.order.client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ecommerce.object_jars.dto.CustomerDTO;

@FeignClient(name = "customer-service", url = "${application.config.customer-url}")
public interface CustomerClient {

	@GetMapping("/get/{id}")
	Optional<CustomerDTO> findCustomerById(@PathVariable("id") String customerId);
}
