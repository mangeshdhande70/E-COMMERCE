package com.customer.service;

import ecommerce.object_jars.dto.CustomerDTO;

public interface CustomerService {
	
	public CustomerDTO createCustomer(CustomerDTO customerDTO);
	public CustomerDTO getCustomerById(String id);
	public CustomerDTO updateCustomer(CustomerDTO customerDTO);
	public boolean deleteCustomer(String id);
	
}
