package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.service.ProductService;

import ecommerce.object_jars.dto.ProductPurchaseRequest;
import ecommerce.object_jars.dto.ProductPurchaseResponse;
import ecommerce.object_jars.dto.ProductRequest;
import ecommerce.object_jars.dto.ProductResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/products")
public class ProductController {

	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping("/purchase")
	public ResponseEntity<List<ProductPurchaseResponse>> purchaseProducts(
			@RequestBody List<ProductPurchaseRequest> request) {
		return ResponseEntity.ok(productService.purchaseProducts(request));
	}
	
	@PostMapping("/create")
	public ResponseEntity<Integer> createProduct(@RequestBody @Valid ProductRequest request) {
		return ResponseEntity.ok(productService.createProduct(request));
	}
	
	@GetMapping("/{product-id}")
	public ResponseEntity<ProductResponse> findById(@PathVariable("product-id") Integer productId) {
		return ResponseEntity.ok(productService.findById(productId));
	}

	@GetMapping
	public ResponseEntity<List<ProductResponse>> findAll() {
		return ResponseEntity.ok(productService.findAll());
	}

}
