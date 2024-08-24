package com.notification.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.notification.service.email.EmailTemplates;

import ecommerce.object_jars.dto.ProductDTO;

@Service
public class TemplateCreate {
	
	@Autowired
	private SpringTemplateEngine templateEngine;
	
	public String getTemplate(List<ProductDTO> products) {
		
		final String templateName = EmailTemplates.ORDER_CONFIRMATION.getTemplate();

		Map<String, Object> variables = new HashMap<>();
		variables.put("customerName", "customerName");
		variables.put("totalAmount", "amount");
		variables.put("orderReference", "orderReference");
		variables.put("products", products);

		Context context = new Context();
		context.setVariables(variables);

		String htmlTemplate = templateEngine.process(templateName, context);
  
		return htmlTemplate;
		
	}

}
