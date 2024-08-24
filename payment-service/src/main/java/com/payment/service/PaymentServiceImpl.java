package com.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.dao.PaymentRepository;
import com.payment.kafka.NotificationProducer;

import ecommerce.object_jars.dto.PaymentNotificationRequest;
import ecommerce.object_jars.dto.PaymentRequest;
import ecommerce.object_jars.utility.PaymentMapper;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	  private final PaymentRepository repository;
	  private final NotificationProducer notificationProducer;
	  
	  @Autowired
	  public PaymentServiceImpl(PaymentRepository repository,NotificationProducer notificationProducer) {
			this.repository = repository;
			this.notificationProducer=notificationProducer;
			
		}
	  

		@Override
		public Integer createPayment(PaymentRequest request) {
			var payment = this.repository.save(PaymentMapper.toPayment(request));

			PaymentNotificationRequest paymentNotificationRequest = PaymentNotificationRequest.builder()
					.amount(request.getAmount()).orderReference(request.getOrderReference())
					.paymentMethod(request.getPaymentMethod()).customerFirstname(request.getCustomer().getFirstname())
					.customerLastname(request.getCustomer().getLastname())
					.customerEmail(request.getCustomer().getEmail()).build();

			this.notificationProducer.sendNotification(paymentNotificationRequest);
			return payment.getId();
		}

}
