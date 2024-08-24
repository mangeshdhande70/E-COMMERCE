package com.product.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.object_jars.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
    List<Product> findAllByIdInOrderById(List<Integer> ids);

}
