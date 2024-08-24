package com.notification.kafka;

import static java.lang.String.format;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.notification.repo.NotificationRepository;
import com.notification.service.email.EmailService;

import ecommerce.object_jars.dto.NOrderConfirmation;
import ecommerce.object_jars.dto.PaymentConfirmation;
import ecommerce.object_jars.entity.Notification;
import ecommerce.object_jars.entity.NotificationType;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationsConsumer {

	private final NotificationRepository repository;

	private final EmailService emailService;

	@KafkaListener(topics = "payment-topic")
	public void consumePaymentSuccessNotifications(PaymentConfirmation paymentConfirmation) throws MessagingException {
		log.info(format("Consuming the message from payment-topic Topic:: %s", paymentConfirmation));
		repository.save(Notification.builder().id(UUID.randomUUID().toString())
				.type(NotificationType.PAYMENT_CONFIRMATION)
				.notificationDate(LocalDateTime.now()).paymentConfirmation(paymentConfirmation).build());
		var customerName = paymentConfirmation.getCustomerFirstname() + " " + paymentConfirmation.getCustomerLastname();
		emailService.sendPaymentSuccessEmail(paymentConfirmation.getCustomerEmail(), customerName,
				paymentConfirmation.getAmount(), paymentConfirmation.getOrderReference());
	}

	@KafkaListener(topics = "order-topic")
	public void consumeOrderConfirmationNotifications(NOrderConfirmation orderConfirmation)
			throws MessagingException {
		log.info(format("Consuming the message from order-topic Topic:: %s", orderConfirmation));
		repository.save(Notification.builder().id(UUID.randomUUID().toString()).type(NotificationType.ORDER_CONFIRMATION)
				.notificationDate(LocalDateTime.now()).nOrderConfirmation(orderConfirmation).build());
		var customerName = orderConfirmation.getCustomer().getFirstname() + " "
				+ orderConfirmation.getCustomer().getLastname();

		emailService.sendOrderConfirmationEmail(orderConfirmation.getCustomer().getEmail(), customerName,
				orderConfirmation.getTotalAmount(), orderConfirmation.getOrderReference(),
				orderConfirmation.getProducts());
	}
}