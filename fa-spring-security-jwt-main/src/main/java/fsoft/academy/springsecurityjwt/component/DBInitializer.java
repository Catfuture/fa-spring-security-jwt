package fsoft.academy.springsecurityjwt.component;

import java.math.BigDecimal;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import fsoft.academy.springsecurityjwt.common.ProductCondition;
import fsoft.academy.springsecurityjwt.common.Role;
import fsoft.academy.springsecurityjwt.entity.Product;
import fsoft.academy.springsecurityjwt.entity.User;
import fsoft.academy.springsecurityjwt.repository.ProductRepository;
import fsoft.academy.springsecurityjwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class DBInitializer {
	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;
	private final ProductRepository productRepository;

	@PostConstruct
	@Transactional
	public void init() {
		if (userRepository.count() == 0) {
			userRepository.saveAll(createSampleUsers());
		}
		if (productRepository.count() == 0) {
			productRepository.saveAll(createSampleProducts());
		}
	}

	private List<User> createSampleUsers() {
		String defaultPassword = "123456";
		return List.of(
			new User(null, "admin", passwordEncoder.encode(defaultPassword), "Quản trị", Role.ADMIN),
			new User(null, "user", passwordEncoder.encode(defaultPassword), "Người dùng", Role.USER),
			new User(null, "vu", passwordEncoder.encode(defaultPassword), "Vũ", Role.USER)
		);
	}

	private List<Product> createSampleProducts() {
		return List.of(
			new Product(
				null,
				"P20 Pro 128GB Dual SIM Twilight",
				BigDecimal.valueOf(899),
				"USD",
				600L,
				"""
				A smartphone is a handheld personal computer with a mobile operating system and an integrated mobile broadband cellular network connection for voice, SMS, and Internet data communication; most, if not all, smartphones also support Wi-Fi""",
				"Unknown",
				"Unknown",
				ProductCondition.NEW,
				"/img/huawei.jpg"
			),
			new Product(
				null,
				"iPhone 8 Plus 64GB PRODUCT RED",
				BigDecimal.valueOf(1009),
				"USD",
				250L,
				"""
				A smartphone is a handheld personal computer with a mobile operating system and an integrated mobile broadband cellular network connection for voice, SMS, and Internet data communication; most, if not all, smartphones also support Wi-Fi""",
				"Apple",
				"apple",
				ProductCondition.OLD,
				"/img/iphone-8-plus-64gb.jpg"
			),
			new Product(
				null,
				"Iphone X",
				BigDecimal.valueOf(1099),
				"USD",
				800L,
				"""
				A smartphone is a handheld personal computer with a mobile operating system and an integrated mobile broadband cellular network connection for voice, SMS, and Internet data communication; most, if not all, smartphones also support Wi-Fi""",
				"Apple",
				"apple",
				null,
				"/img/iphone-x-mau-xam-didongviet.jpg"
			),
			new Product(
				null,
				"Galaxy S8",
				BigDecimal.valueOf(699),
				"USD",
				200L,
				"""
				A smartphone is a handheld personal computer with a mobile operating system and an integrated mobile broadband cellular network connection for voice, SMS, and Internet data communication; most, if not all, smartphones also support Wi-Fi""",
				"Samsung",
				"samsung",
				ProductCondition.REFURBISHED,
				"/img/samsung-galaxy-s8-4-300x300.jpg"
			)
		);
	}
}
