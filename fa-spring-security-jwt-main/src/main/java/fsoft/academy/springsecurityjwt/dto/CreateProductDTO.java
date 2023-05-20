package fsoft.academy.springsecurityjwt.dto;

import java.math.BigDecimal;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import fsoft.academy.springsecurityjwt.common.ProductCondition;
import lombok.Getter;

@Getter
public class CreateProductDTO {
	@NotEmpty(message = "Name is required")
	private String name;

	@NotNull(message = "Price is required")
	private BigDecimal price;

	@NotEmpty(message = "Unit price is required")
	private String unitPrice;

	@NotNull(message = "Units in stock is required")
	private Long unitsInStock;

	private String description;
	private String manufacturer;
	private String category;
	private ProductCondition productCondition;
	private String imageFile;
}
