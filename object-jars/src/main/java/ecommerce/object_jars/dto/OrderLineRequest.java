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
public class OrderLineRequest {

	private Integer id;
	private Integer orderId;
	private Integer productId;
	private Integer quantity;

}
