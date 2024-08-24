package com.product.service;

import java.util.List;

import ecommerce.object_jars.dto.ProductPurchaseRequest;
import ecommerce.object_jars.dto.ProductPurchaseResponse;
import ecommerce.object_jars.dto.ProductRequest;
import ecommerce.object_jars.dto.ProductResponse;

public interface ProductService {
	
	public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request);
	public List<ProductResponse> findAll();
	public ProductResponse findById(Integer id);
	public Integer createProduct(ProductRequest request);

}
