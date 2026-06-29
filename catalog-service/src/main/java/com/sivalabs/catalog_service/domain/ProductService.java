package com.sivalabs.catalog_service.domain;

import com.sivalabs.catalog_service.ApplicationProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {
	private final ProductRepository productRepository;
	private final ApplicationProperties properties;

	ProductService(ProductRepository productRepository, ApplicationProperties properties) {
		this.productRepository = productRepository;
		this.properties = properties;
	}

	public PagedResult<Product> getProducts(int pageNo) {
		Sort sort = Sort.by("name").ascending();
		pageNo = pageNo <= 1 ? 0 : pageNo - 1;
		Pageable pageable = PageRequest.of(pageNo, properties.pageSize(), sort);
		// TODO (bachir.bachir): Study <spotless:palantirJavaFormat> to never join
		// already wrapped lines...
		Page<Product> productsPage = productRepository.findAll(pageable).map(ProductMapper::toProduct);

		return new PagedResult<>(
				productsPage.getContent(),
				productsPage.getTotalElements(),
				productsPage.getNumber() + 1,
				productsPage.getTotalPages(),
				productsPage.isFirst(),
				productsPage.isLast(),
				productsPage.hasNext(),
				productsPage.hasPrevious());
	}

}
