package ecommerce.object_jars.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductRequest {
	
	Integer id;
    @NotNull(message = "Product name is required")
    String name;
    
    @NotNull(message = "Product description is required")
    String description;
    
    @Positive(message = "Available quantity should be positive")
    double availableQuantity;
    
    @Positive(message = "Price should be positive")
    double price;
    
    @NotNull(message = "Product category is required")
    Integer categoryId;

}
