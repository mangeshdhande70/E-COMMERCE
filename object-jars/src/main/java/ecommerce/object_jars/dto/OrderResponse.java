package ecommerce.object_jars.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
@JsonInclude(Include.NON_EMPTY)
public class OrderResponse{
    Integer id;
    String reference;
    double amount;
    PaymentMethod paymentMethod;
    String customerId;
}