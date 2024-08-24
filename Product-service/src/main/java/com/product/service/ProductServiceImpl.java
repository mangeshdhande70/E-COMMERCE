package com.product.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.dao.ProductRepository;
import com.product.exception.ProductPurchaseException;

import ecommerce.object_jars.dto.ProductPurchaseRequest;
import ecommerce.object_jars.dto.ProductPurchaseResponse;
import ecommerce.object_jars.dto.ProductRequest;
import ecommerce.object_jars.dto.ProductResponse;
import ecommerce.object_jars.utility.ProductMapper;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;
	
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	@Transactional(rollbackFor = ProductPurchaseException.class)
	public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request) {
		
		
		var productIds = request.stream().map(ProductPurchaseRequest::getProductId).toList();
		
		
		var storedProducts = productRepository.findAllByIdInOrderById(productIds);
		if (productIds.size() != storedProducts.size()) {
			throw new ProductPurchaseException("One or more products does not exist");
		}
		var sortedRequest = request.stream().sorted(Comparator.comparing(ProductPurchaseRequest::getProductId)).toList();
		var purchasedProducts = new ArrayList<ProductPurchaseResponse>();
		
		for (int i = 0; i < storedProducts.size(); i++) {
			var product = storedProducts.get(i);
			var productRequest = sortedRequest.get(i);
			if (product.getAvailableQuantity() < productRequest.getQuantity()) {
				throw new ProductPurchaseException(
						"Insufficient stock quantity for product with ID:: " + productRequest.getProductId());
			}
			var newAvailableQuantity = product.getAvailableQuantity() - productRequest.getQuantity();
			product.setAvailableQuantity(newAvailableQuantity);
			productRepository.save(product);
			purchasedProducts.add(ProductMapper.toproductPurchaseResponse(product, productRequest.getQuantity()));
		}
		return purchasedProducts;
	}

	@Override
	public Integer createProduct(ProductRequest request) {
		var product =ProductMapper.toProduct(request);
		return productRepository.save(product).getId();
	}

	@Override
	public ProductResponse findById(Integer id) {
		return productRepository.findById(id).map(ProductMapper::toProductResponse)
				.orElseThrow(() -> new EntityNotFoundException("Product not found with ID:: " + id));
	}

	@Override
	public List<ProductResponse> findAll() {
		return productRepository.findAll().stream().map(ProductMapper::toProductResponse).collect(Collectors.toList());
	}
	
}
