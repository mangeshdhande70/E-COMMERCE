package ecommerce.object_jars.utility;

import ecommerce.object_jars.dto.OrderLineRequest;
import ecommerce.object_jars.dto.OrderLineResponse;
import ecommerce.object_jars.entity.Order;
import ecommerce.object_jars.entity.OrderLine;

public class OrderLineMapper {
    public static OrderLine mapToOrderLine(OrderLineRequest request) {
    	
		Order order = Order.builder().id(request.getOrderId()).build();
        return OrderLine.builder()
                .id(request.getOrderId())
                .productId(request.getProductId())
                .quantity(request.getQuantity())
                .order(order)
                .build();
    }

	public static OrderLineResponse mapToOrderLineResponse(OrderLine orderLine) {
		return OrderLineResponse.builder().id(orderLine.getId()).quantity(orderLine.getQuantity()).build();
	}
}