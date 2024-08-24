package ecommerce.object_jars.dto;

import ecommerce.object_jars.entity.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

	private String id;

	@NotNull(message = "Customer firstname is required")
	private String firstname;
	
	@NotNull(message = "Customer firstname is required")
	private String lastname;
	
	@NotNull(message = "Customer Email is required")
	@Email(message = "Customer Email is not a valid email address")
	private String email;
	
	private Address address;
}
