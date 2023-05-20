package fsoft.academy.springsecurityjwt.service;

import java.util.List;
import fsoft.academy.springsecurityjwt.dto.CreateProductDTO;
import fsoft.academy.springsecurityjwt.dto.ProductInfoDTO;

public interface ProductService {
	List<ProductInfoDTO> listProducts();

	ProductInfoDTO getProduct(Long id);

	void createProduct(CreateProductDTO dto);
}
