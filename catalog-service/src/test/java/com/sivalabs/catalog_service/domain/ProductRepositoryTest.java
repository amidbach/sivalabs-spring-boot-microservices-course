package com.sivalabs.catalog_service.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.sivalabs.catalog_service.TestcontainersConfiguration;
import java.util.List;
import lombok.AccessLevel;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@Import(TestcontainersConfiguration.class)
@Sql("/test-data.sql")
@Slf4j( // spotless:off
		access = AccessLevel.PROTECTED,     // <-- The generated 'log' field is protected, allowing subclasses to use it directly
		topic = "[catalog-service]"         // <-- By default, the logger name (or topic) is the fully qualified name of the class
)                                           //     Why use a custom topic? ==> Log Aggregation, Filtering, etc.     // spotless:on
class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepository;

	// You don't need to test the methods provided by Spring Data JPA.
	// This test is to demonstrate how to write tests for the repository layer.
	@Test
	void shouldGetAllProducts() {
		List<ProductEntity> products = productRepository.findAll();
		int expectedProducts = 13;
		int productsFound = products.size();
		log.debug(
				"Next Error Assertion --> Expected {} 'Product' entities: {} {} were found.",
				expectedProducts,
				(expectedProducts != productsFound ? "BUT" : "AND"),
				productsFound);
		assertThat(products).hasSize(expectedProducts);
	}

}
