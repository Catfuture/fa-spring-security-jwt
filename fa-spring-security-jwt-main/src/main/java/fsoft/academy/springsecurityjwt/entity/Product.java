package fsoft.academy.springsecurityjwt.entity;

import java.math.BigDecimal;
import javax.persistence.*;
import fsoft.academy.springsecurityjwt.common.ProductCondition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private BigDecimal price;

	@Column(nullable = false)
	private String unitPrice;

	@Column(nullable = false)
	private Long unitsInStock;

	@Column(length = 1000)
	private String desciption;

	private String manufacturer;
	private String category;

	@Enumerated(EnumType.STRING)
	private ProductCondition productCondition; // Ko dùng được "condition" do trùng từ khóa

	private String imageFile;
}
