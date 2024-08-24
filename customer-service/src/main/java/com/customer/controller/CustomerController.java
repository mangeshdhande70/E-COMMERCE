package com.customer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.service.CustomerService;

import ecommerce.object_jars.dto.CustomerDTO;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1/customers")
@Slf4j
public class CustomerController {
	
	private CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping(value = "/create")
	public ResponseEntity<CustomerDTO> createCustomer(@RequestBody @Validated CustomerDTO customerDTO){
		CustomerDTO response = customerService.createCustomer(customerDTO);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
		
	}
	
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable String id){
		CustomerDTO response = customerService.getCustomerById(id);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO){
		log.info("Request come for update record for user id {}",customerDTO.getId());
		CustomerDTO response = customerService.updateCustomer(customerDTO);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Boolean> deleteCustomerById(@PathVariable String id){
		boolean response = customerService.deleteCustomer(id);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	

}
