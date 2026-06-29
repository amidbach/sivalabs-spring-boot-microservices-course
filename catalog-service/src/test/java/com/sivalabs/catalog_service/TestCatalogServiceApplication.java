package com.sivalabs.catalog_service;

import org.springframework.boot.SpringApplication;

public class TestCatalogServiceApplication {

	public static void main(String[] args) {
		// TODO (bachir.bachir): Study <spotless:palantirJavaFormat> to never join
		// already wrapped lines...
		// spotless:off
		SpringApplication
				.from(CatalogServiceApplication::main)
				.with(TestcontainersConfiguration.class)
				.run(args);
		// spotless:on
	}

}
