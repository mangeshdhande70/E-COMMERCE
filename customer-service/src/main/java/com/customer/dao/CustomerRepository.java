package com.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.object_jars.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {
	
	

}
