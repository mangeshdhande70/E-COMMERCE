package ecommerce.object_jars.utility;

import java.util.UUID;

import ecommerce.object_jars.dto.CustomerDTO;
import ecommerce.object_jars.entity.Customer;

public class CustomerMapper {

	public static Customer mapToCustomer(CustomerDTO request) {

		if (request == null) {
			return null;
		}

		return Customer.builder().id(UUID.randomUUID().toString()).firstname(request.getFirstname())
				.lastname(request.getLastname()).email(request.getEmail()).address(request.getAddress()).isActive(true)
				.build();

	}

	public static CustomerDTO mapToCustomerDTO(Customer customer) {

		return CustomerDTO.builder().id(customer.getId()).firstname(customer.getFirstname())
				.lastname(customer.getLastname()).email(customer.getEmail()).address(customer.getAddress()).build();

	}

}
