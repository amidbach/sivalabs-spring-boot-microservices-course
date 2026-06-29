package com.sivalabs.catalog_service.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.sivalabs.catalog_service.TestcontainersConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@DataJpaTest
@Import(TestcontainersConfiguration.class)
class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepository;

	// You don't need to test the methods provided by Spring Data JPA.
	// This test is to demonstrate how to write tests for the repository layer.
	@Test
	void shouldGetAllProducts() {
		List<ProductEntity> products = productRepository.findAll();
		assertThat(products).hasSize(15);
	}
}