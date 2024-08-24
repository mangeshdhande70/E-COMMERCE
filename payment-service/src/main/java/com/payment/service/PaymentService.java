package com.payment.service;

import ecommerce.object_jars.dto.PaymentRequest;

public interface PaymentService {

	public Integer createPayment(PaymentRequest request);

}
