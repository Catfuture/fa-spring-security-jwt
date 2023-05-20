package fsoft.academy.springsecurityjwt.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import fsoft.academy.springsecurityjwt.dto.CreateProductDTO;
import fsoft.academy.springsecurityjwt.dto.ProductInfoDTO;
import fsoft.academy.springsecurityjwt.entity.Product;
import fsoft.academy.springsecurityjwt.exception.ApiException;
import fsoft.academy.springsecurityjwt.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	private final ProductRepository productRepository;

	@Override
	public List<ProductInfoDTO> listProducts() {
		return productRepository.findAll().stream()
			.map(ProductInfoDTO::new)
			.toList();
	}

	@Override
	public ProductInfoDTO getProduct(Long id) {
		Product product = productRepository.findById(id)
			.orElseThrow(() -> new ApiException(404, "Product not found"));
		return new ProductInfoDTO(product);
	}

	@Override
	@Transactional
	public void createProduct(CreateProductDTO dto) {
		Product product = new Product(
			null,
			dto.getName(),
			dto.getPrice(),
			dto.getUnitPrice(),
			dto.getUnitsInStock(),
			dto.getDescription(),
			dto.getManufacturer(),
			dto.getCategory(),
			dto.getProductCondition(),
			dto.getImageFile()
		);
		productRepository.save(product);
	}
}
