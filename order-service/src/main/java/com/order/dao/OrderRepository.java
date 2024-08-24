package com.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.object_jars.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
