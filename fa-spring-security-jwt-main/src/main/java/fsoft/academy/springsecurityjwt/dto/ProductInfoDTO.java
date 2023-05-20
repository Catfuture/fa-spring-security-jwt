package fsoft.academy.springsecurityjwt.dto;

import java.math.BigDecimal;
import fsoft.academy.springsecurityjwt.common.ProductCondition;
import fsoft.academy.springsecurityjwt.entity.Product;
import lombok.Getter;

@Getter
public class ProductInfoDTO {
	private final Long id;
	private final String name;
	private final BigDecimal price;
	private final String unitPrice;
	private final Long unitsInStock;
	private final String description;
	private final String manufacturer;
	private final String category;
	private final ProductCondition productCondition;
	private final String imageFile;

	public ProductInfoDTO(Product product) {
		id = product.getId();
		name = product.getName();
		price = product.getPrice();
		unitPrice = product.getUnitPrice();
		unitsInStock = product.getUnitsInStock();
		description = product.getDesciption();
		manufacturer = product.getManufacturer();
		category = product.getCategory();
		productCondition = product.getProductCondition();
		imageFile = product.getImageFile();
	}
}
