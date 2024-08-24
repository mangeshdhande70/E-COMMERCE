package ecommerce.object_jars.utility;

import ecommerce.object_jars.dto.ProductPurchaseResponse;
import ecommerce.object_jars.dto.ProductRequest;
import ecommerce.object_jars.dto.ProductResponse;
import ecommerce.object_jars.entity.Category;
import ecommerce.object_jars.entity.Product;

public class ProductMapper {
	
	public static Product toProduct(ProductRequest request) {
        return Product.builder()
                .id(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .availableQuantity(request.getAvailableQuantity())
                .price(request.getPrice())
                .category(
                        Category.builder()
                                .id(request.getCategoryId())
                                .build()
                )
                .build();
    }

    public static ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getAvailableQuantity(),
                product.getPrice(),
                product.getCategory().getId(),
                product.getCategory().getName(),
                product.getCategory().getDescription()
        );
    }

    public static ProductPurchaseResponse toproductPurchaseResponse(Product product, Integer quantity) {
        return new ProductPurchaseResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                quantity
        );
    }

}
