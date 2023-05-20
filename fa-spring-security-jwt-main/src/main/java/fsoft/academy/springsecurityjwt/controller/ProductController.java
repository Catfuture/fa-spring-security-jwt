package fsoft.academy.springsecurityjwt.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import fsoft.academy.springsecurityjwt.dto.CreateProductDTO;
import fsoft.academy.springsecurityjwt.dto.ProductInfoDTO;
import fsoft.academy.springsecurityjwt.service.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;

	@GetMapping
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public List<ProductInfoDTO> listProducts() {
		return productService.listProducts();
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public ProductInfoDTO getProduct(@PathVariable Long id) {
		return productService.getProduct(id);
	}

	@PostMapping
	@PreAuthorize("hasAuthority('ADMIN')")
	public void createProduct(@RequestBody @Valid CreateProductDTO dto) {
		productService.createProduct(dto);
	}
}
