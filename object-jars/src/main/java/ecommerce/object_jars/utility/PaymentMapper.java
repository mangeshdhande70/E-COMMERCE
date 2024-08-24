package ecommerce.object_jars.utility;

import java.time.LocalDateTime;

import ecommerce.object_jars.dto.PaymentRequest;
import ecommerce.object_jars.entity.Payment;

public class PaymentMapper {

	public static Payment toPayment(PaymentRequest request) {
		if (request == null) {
			return null;
		}
		return Payment.builder().id(request.getId()).paymentMethod(request.getPaymentMethod())
				.amount(request.getAmount()).orderId(request.getOrderId()).createdDate(LocalDateTime.now())
				.lastModifiedDate(LocalDateTime.now()).build();
	}

}
