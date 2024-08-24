package com.order.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.dao.OrderLineRepository;

import ecommerce.object_jars.dto.OrderLineRequest;
import ecommerce.object_jars.dto.OrderLineResponse;
import ecommerce.object_jars.entity.OrderLine;
import ecommerce.object_jars.utility.OrderLineMapper;

@Service
public class OrderLineService {

    private final OrderLineRepository repository;

    @Autowired
    public OrderLineService(OrderLineRepository repository) {
		this.repository = repository;
	}

	public Integer saveOrderLine(OrderLineRequest request) {
        OrderLine orderLine = OrderLineMapper.mapToOrderLine(request);
        return repository.save(orderLine).getId();
    }

    public List<OrderLineResponse> findAllByOrderId(Integer orderId) {
        return repository.findAllByOrderId(orderId)
                .stream()
                .map(OrderLineMapper::mapToOrderLineResponse)
                .collect(Collectors.toList());
    }

}