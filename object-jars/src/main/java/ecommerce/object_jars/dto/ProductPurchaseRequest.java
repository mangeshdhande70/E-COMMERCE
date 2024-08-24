package ecommerce.object_jars.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductPurchaseRequest{
        @NotNull(message = "Product is mandatory")
        Integer productId;
        @Positive(message = "Quantity is mandatory")
        Integer quantity;
}