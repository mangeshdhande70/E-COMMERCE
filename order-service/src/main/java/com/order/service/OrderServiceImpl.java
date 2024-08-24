package com.order.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.client.CustomerClient;
import com.order.client.PaymentClient;
import com.order.client.ProductClient;
import com.order.dao.OrderRepository;
import com.order.exception.BusinessException;
import com.order.kafka.OrderProducer;

import ecommerce.object_jars.dto.CustomerDTO;
import ecommerce.object_jars.dto.OrderConfirmation;
import ecommerce.object_jars.dto.OrderLineRequest;
import ecommerce.object_jars.dto.OrderRequest;
import ecommerce.object_jars.dto.OrderResponse;
import ecommerce.object_jars.dto.PaymentRequest;
import ecommerce.object_jars.dto.PurchaseRequest;
import ecommerce.object_jars.dto.PurchaseResponse;
import ecommerce.object_jars.entity.Order;
import ecommerce.object_jars.utility.OrderMapper;
import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;
	private final CustomerClient customerClient;
	private final ProductClient productClient;
	private final OrderLineService orderLineService;
	private final PaymentClient paymentClient;
	private final OrderProducer orderProducer;

	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository, OrderLineService orderLineService,
			OrderProducer orderProducer, ProductClient productClient, CustomerClient customerClient,
			PaymentClient paymentClient) {
		this.orderRepository = orderRepository;
		this.customerClient = customerClient;
		this.productClient = productClient;
		this.orderLineService = orderLineService;
		this.paymentClient = paymentClient;
		this.orderProducer = orderProducer;
	}

	@Override
	public Integer createOrder(OrderRequest request) {

		CustomerDTO customer = this.customerClient.findCustomerById(request.getCustomerId()).orElseThrow(
				() -> new BusinessException("Cannot create order:: No customer exists with the provided ID"));

		List<PurchaseResponse> purchasedProducts = productClient.purchaseProducts(request.getProducts());

		double totalAmount = 0.0D;
		for (PurchaseResponse response : purchasedProducts) {
			totalAmount += response.getPrice() * response.getQuantity(); 
		}
		request.setAmount(totalAmount);
		Order order = orderRepository.save(OrderMapper.toOrder(request));

		for (PurchaseRequest purchaseRequest : request.getProducts()) {
			OrderLineRequest orderLineRequest = OrderLineRequest.builder().orderId(order.getId())
					.productId(purchaseRequest.getProductId()).quantity(purchaseRequest.getQuantity()).build();

			orderLineService.saveOrderLine(orderLineRequest);
		}

		PaymentRequest paymentRequest = PaymentRequest.builder().amount(request.getAmount())
				.paymentMethod(request.getPaymentMethod()).orderId(order.getId()).orderReference(order.getReference())
				.customer(customer).build();

		paymentClient.requestOrderPayment(paymentRequest);

		OrderConfirmation orderConfirmation = OrderConfirmation.builder().orderReference(request.getReference())
				.totalAmount(request.getAmount()).paymentMethod(request.getPaymentMethod()).customer(customer)
				.products(purchasedProducts).build();

		orderProducer.sendOrderConfirmation(orderConfirmation);

		return order.getId();
	}

	@Override
	public List<OrderResponse> findAllOrder() {
		 return this.orderRepository.findAll()
                .stream()
                .map(OrderMapper::fromOrder)
                .collect(Collectors.toList());
	}

	@Override
	public OrderResponse getOrderById(Integer id) {
		   return this.orderRepository.findById(id)
	                .map(OrderMapper::fromOrder)
	                .orElseThrow(() -> new EntityNotFoundException(String.format("No order found with the provided ID: %d", id)));
	}

}
