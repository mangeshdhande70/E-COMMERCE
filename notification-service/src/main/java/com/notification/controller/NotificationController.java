
package com.notification.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notification.service.email.EmailService;

import ecommerce.object_jars.dto.ProductDTO;
import jakarta.mail.MessagingException;

@RestController
public class NotificationController {

	@Autowired
	private EmailService emailService;

	@Autowired
	private TemplateCreate templateCreate;
	
	
	@GetMapping("/send")
	public String sendEmail() throws MessagingException {
		ProductDTO productDTO = ProductDTO.builder().description("description").name("Bottle").productId(1).price(22.2)
				.quantity(1).build();
		List<ProductDTO> products = List.of(productDTO);
		emailService.sendOrderConfirmationEmail("mangeshdhande70@gmail.com", "Mangesh", 15.5, "fasdghf", list);

		return templateCreate.getTemplate(products);
//		return "true";
	}
}
