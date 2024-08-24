package com.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.object_jars.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
