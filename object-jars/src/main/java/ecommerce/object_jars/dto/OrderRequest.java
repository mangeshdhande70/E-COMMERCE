package ecommerce.object_jars.dto;

import java.util.List;

import ecommerce.object_jars.entity.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
@ToString
@Builder
public class OrderRequest {
	
	Integer id;
    String reference;
    @Positive(message = "Order amount should be positive")
    double amount;
    @NotNull(message = "Payment method should be precised")
    PaymentMethod paymentMethod;
    @NotNull(message = "Customer should be present")
    @NotEmpty(message = "Customer should be present")
    @NotBlank(message = "Customer should be present")
    String customerId;
    @NotEmpty(message = "You should at least purchase one product")
    List<PurchaseRequest> products;

}
