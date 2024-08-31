package com.customer.service;

import org.springframework.stereotype.Service;

import com.customer.dao.CustomerRepository;
import com.customer.exceptions.CustomerNotFoundException;

import ecommerce.object_jars.dto.CustomerDTO;
import ecommerce.object_jars.entity.Customer;
import ecommerce.object_jars.utility.CustomerMapper;
import ecommerce.object_jars.utility.StringUtility;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

  // test
  //Test
	
	private CustomerRepository customerRepository;
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	

	@Override
	public CustomerDTO createCustomer(CustomerDTO customerDTO) {
		Customer customer = CustomerMapper.mapToCustomer(customerDTO);
		Customer response = customerRepository.save(customer);
		return CustomerMapper.mapToCustomerDTO(response);
	}

	@Override
	public CustomerDTO getCustomerById(String id) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found with the provided ID : " + id));
		return CustomerMapper.mapToCustomerDTO(customer);
	}


	@Override
	public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
		Customer customer = customerRepository.findById(customerDTO.getId())
				.orElseThrow(() -> new CustomerNotFoundException(
						"Customer not found with the provided ID : " + customerDTO.getId()));

		mergeCustomer(customer, customerDTO);
		log.info("Affter update record {}",customer);
		Customer response = customerRepository.save(customer);
		return CustomerMapper.mapToCustomerDTO(response);
	}


	@Override
	public boolean deleteCustomer(String id) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException(
						"Customer not found with the provided ID : " + id));
		customer.setActive(false);
		customerRepository.save(customer);
		return true;
	}
	
	private void mergeCustomer(Customer customer, CustomerDTO request) {

		if (!StringUtility.isNullOrEmpty(request.getFirstname())) {
			customer.setFirstname(request.getFirstname());
		}
		if (!StringUtility.isNullOrEmpty(request.getEmail())) {
			customer.setEmail(request.getEmail());
		}
		if (request.getAddress() != null) {
			customer.setAddress(request.getAddress());
		}
	}

}
