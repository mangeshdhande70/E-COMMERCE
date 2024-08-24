package com.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.service.OrderService;

import ecommerce.object_jars.dto.OrderRequest;
import ecommerce.object_jars.dto.OrderResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/orders")
public class OrderController {
	
	private final OrderService orderService;
	
	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping(value = "/create")
	public ResponseEntity<Integer> createOrder(@RequestBody @Valid OrderRequest request) {
		return ResponseEntity.ok(this.orderService.createOrder(request));
	}

	@GetMapping(value = "/get/all")
	public ResponseEntity<List<OrderResponse>> findAll() {
		return ResponseEntity.ok(this.orderService.findAllOrder());
	}

	@GetMapping("/get/{order-id}")
	public ResponseEntity<OrderResponse> findById(@PathVariable("order-id") Integer orderId) {
		return ResponseEntity.ok(this.orderService.getOrderById(orderId));
	}

}
