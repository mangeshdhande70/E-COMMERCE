package com.payment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.service.PaymentService;

import ecommerce.object_jars.dto.PaymentRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

	private final PaymentService service;

	@PostMapping(value = "/create")
	public ResponseEntity<Integer> createPayment(@RequestBody @Valid PaymentRequest request) {
		return ResponseEntity.ok(this.service.createPayment(request));
	}
}