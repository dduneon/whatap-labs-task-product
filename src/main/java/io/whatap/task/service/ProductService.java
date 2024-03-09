package io.whatap.task.service;

import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import io.whatap.task.common.domain.PageInfo;
import io.whatap.task.common.dto.PagedResponse;
import io.whatap.task.dto.req.ProductCreateRequestDto;
import io.whatap.task.dto.req.ProductUpdateRequestDto;
import io.whatap.task.dto.res.ProductResponseDto;
import io.whatap.task.entity.Product;
import io.whatap.task.exception.ProductNotFoundException;
import io.whatap.task.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Objects;

/**
 * 상품에 관한 CRUD 를 제공하는 서비스 클래스
 *
 * @author 김준현
 * @version 2024. 03. 05
 */
@ApplicationScoped
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public ProductResponseDto readProduct(Long id) {
        Product product = productRepository.findById(id);
        // 해당 상품 아이디를 가지는 상품이 존재하지 않는 경우
        if(Objects.isNull(product)) {
            throw new ProductNotFoundException(id);
        }
        return new ProductResponseDto(product.getId(), product.getName(), product.getDescription());
    }

    @Transactional
    public PagedResponse<ProductResponseDto> readProductPagination(Page page) {
        List<ProductResponseDto> data = productRepository.findAll(Sort.by("id"))
                .page(page).list().stream()
                .map(ProductResponseDto::toDto)
                .toList();

        int count = (int) productRepository.count();
        PageInfo pageInfo = PageInfo.builder()
                .page(page.index)
                .size(page.size)
                .totalElements(count)
                .totalPages(count / page.size + (count % page.size != 0 ? 1 : 0))
                .build();

        return new PagedResponse<>(data, pageInfo);
    }

    @Transactional
    public void createProduct(ProductCreateRequestDto productCreateRequestDto) {
        Product product = Product.builder()
                .name(productCreateRequestDto.getName())
                .description(productCreateRequestDto.getDescription())
                .build();
        productRepository.persist(product);
    }

    @Transactional
    public void updateProduct(ProductUpdateRequestDto productUpdateRequestDto) {
        Product product = productRepository.findById(productUpdateRequestDto.getId());
        // 해당 상품 아이디를 가지는 상품이 존재하지 않는 경우
        if(Objects.isNull(product)) {
            throw new ProductNotFoundException(productUpdateRequestDto.getId());
        }
        // Dirty checking 에 의하여 업데이트 쿼리 생성
        product.updateProductName(productUpdateRequestDto.getName());
        product.updateProductDescription(productUpdateRequestDto.getDescription());
    }

    @Transactional
    public void deleteProduct(Long productId) {
        // 해당 상품 아이디를 가지는 상품이 존재하지 않는 경우
        if(!productRepository.deleteById(productId))
            throw new ProductNotFoundException(productId);
    }
}
