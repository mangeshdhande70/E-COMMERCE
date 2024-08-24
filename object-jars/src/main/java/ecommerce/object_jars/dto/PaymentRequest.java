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
public class PaymentRequest{
	    private Integer id;
	    private double amount;
	    private PaymentMethod paymentMethod;
	    private Integer orderId;
	    private String orderReference;
	    private CustomerDTO customer;
}