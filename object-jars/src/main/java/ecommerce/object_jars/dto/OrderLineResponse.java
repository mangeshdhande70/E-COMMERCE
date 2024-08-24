package ecommerce.object_jars.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString
@NoArgsConstructor
public class OrderLineResponse {
	Integer id;
	Integer quantity;
}
