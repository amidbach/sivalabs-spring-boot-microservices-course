package com.sivalabs.catalog_service.web.controllers;

import com.sivalabs.catalog_service.domain.PagedResult;
import com.sivalabs.catalog_service.domain.Product;
import com.sivalabs.catalog_service.domain.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
class ProductController {
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
	private final ProductService productService;

	ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	PagedResult<Product> getProducts(@RequestParam(name = "page", defaultValue = "1") int pageNo) {
		log.info("Fetching products for page: {}", pageNo);
		return productService.getProducts(pageNo);
	}

}
