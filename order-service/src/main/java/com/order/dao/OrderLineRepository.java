package com.order.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.object_jars.entity.OrderLine;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
	
	List<OrderLine> findAllByOrderId(Integer orderId);

}
