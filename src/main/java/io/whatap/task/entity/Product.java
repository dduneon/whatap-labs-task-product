package io.whatap.task.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 상품에 대한 정보를 담고 있는 Product 엔티티 클래스
 *
 * @author 김준현
 * @version 2024. 03. 05
 */

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Product extends PanacheEntity {
    // id 필드는 PanacheEntity 에서 상속되었기 때문에 별도로 선언할 필요가 없음

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_description")
    private String description;
}
