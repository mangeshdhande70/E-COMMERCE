package com.order.service;

import java.util.List;

import ecommerce.object_jars.dto.OrderRequest;
import ecommerce.object_jars.dto.OrderResponse;

public interface OrderService {
	
	public Integer createOrder(OrderRequest request);
	public List<OrderResponse> findAllOrder();
	public OrderResponse getOrderById(Integer id);

}
