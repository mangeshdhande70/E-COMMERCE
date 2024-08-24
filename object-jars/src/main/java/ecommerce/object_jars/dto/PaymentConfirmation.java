package ecommerce.object_jars.dto;

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
public class PaymentConfirmation {

	private String orderReference;
	private double amount;
	private PaymentMethod paymentMethod;
	private String customerFirstname;
	private String customerLastname;
	private String customerEmail;

}
