package io.whatap.task.service;

import io.whatap.task.dto.req.ProductCreateRequestDto;
import io.whatap.task.dto.res.ProductResponseDto;
import io.whatap.task.entity.Product;
import io.whatap.task.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

/**
 * 상품에 관한 CRUD 를 제공하는 서비스 클래스
 *
 * @author 김준현
 * @version 2024. 03. 05
 */
@ApplicationScoped
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public ProductResponseDto readProduct(Long id) {
        Product product = productRepository.findById(id);
        return new ProductResponseDto(product.id, product.getName(), product.getDescription());
    }

    @Transactional
    public void createProduct(ProductCreateRequestDto productCreateRequestDto) {
        Product product = Product.builder()
                .name(productCreateRequestDto.getName())
                .description(productCreateRequestDto.getDescription())
                .build();
        // product.persist(); -> 이것은 무엇인가
        // persist 상태로 만듦
        productRepository.persist(product);

        // 한번 persisted 되면, 엔티티를 명시적으로 저장할 필요가 없음
        // 수정 사항은 트랜잭션 커밋시 자동으로 persisted 됨
    }
}
