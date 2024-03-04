package io.whatap.task.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.whatap.task.entity.Product;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * Product 테이블과 상호작용 하는 ProductRepository 클래스
 *
 * @author 김준현
 * @version 2024. 03. 05
 */
@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {
}
