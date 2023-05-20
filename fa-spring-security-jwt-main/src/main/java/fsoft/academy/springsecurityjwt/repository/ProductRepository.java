package fsoft.academy.springsecurityjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fsoft.academy.springsecurityjwt.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
