package ecommerce.object_jars.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	@Id
	private String id;
	private String firstname;
	private String lastname;
	private String email;
	private boolean isActive;
	@Embedded
	private Address address;
	
	

}
