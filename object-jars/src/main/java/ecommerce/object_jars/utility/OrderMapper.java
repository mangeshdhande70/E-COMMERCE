package ecommerce.object_jars.utility;

import java.time.LocalDateTime;

import ecommerce.object_jars.dto.OrderRequest;
import ecommerce.object_jars.dto.OrderResponse;
import ecommerce.object_jars.entity.Order;

public class OrderMapper {

	public static Order toOrder(OrderRequest request) {
		if (request == null) {
			return null;
		}
		return Order.builder().id(request.getId()).reference(request.getReference())
				.paymentMethod(request.getPaymentMethod()).customerId(request.getCustomerId())
				.totalAmount(request.getAmount()).createdDate(LocalDateTime.now()).lastModifiedDate(LocalDateTime.now())
				.build();
	}

	public static OrderResponse fromOrder(Order order) {

		return OrderResponse.builder().id(order.getId()).reference(order.getReference()).amount(order.getTotalAmount())
				.paymentMethod(order.getPaymentMethod()).customerId(order.getCustomerId()).build();

	}

}
