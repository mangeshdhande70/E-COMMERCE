package ecommerce.object_jars.dto;

import java.util.List;

import ecommerce.object_jars.entity.PaymentMethod;
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
public class OrderConfirmation {

	private String orderReference;
	private double totalAmount;
	private PaymentMethod paymentMethod;
	private CustomerDTO customer;
	List<PurchaseResponse> products;

}