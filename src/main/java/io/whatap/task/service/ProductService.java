package io.whatap.task.service;

import io.whatap.task.dto.res.ProductResponseDto;
import io.whatap.task.entity.Product;
import io.whatap.task.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

/**
 * 상품에 관한 CRUD 를 제공하는 서비스 클래스
 *
 * @author 김준현
 * @version 2024. 03. 05
 */
@ApplicationScoped
public class ProductService {
    @Inject
    ProductRepository productRepository;

    public ProductResponseDto readProduct(Long id) {
        Product product = productRepository.findById(id);
        return new ProductResponseDto(product.id, product.getName(), product.getDescription());
    }
}
