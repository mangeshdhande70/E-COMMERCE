package ecommerce.object_jars.dto;

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
public class ProductResponse{
       private Integer id;
       private String name;
       private String description;
       private double availableQuantity;
       private double price;
       private Integer categoryId;
       private String categoryName;
       private String categoryDescription;
}