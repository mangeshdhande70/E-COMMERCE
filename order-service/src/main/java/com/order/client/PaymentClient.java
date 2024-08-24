package com.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ecommerce.object_jars.dto.PaymentRequest;

@FeignClient(
    name = "product-service",
    url = "${application.config.payment-url}"
)
public interface PaymentClient {

  @PostMapping(value = "/create")
  Integer requestOrderPayment(@RequestBody PaymentRequest request);
}