package ecommerce.object_jars.dto;

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
public class ProductPurchaseResponse {
	private Integer productId;
	private String name;
	private String description;
	private double price;
	private Integer quantity;
}