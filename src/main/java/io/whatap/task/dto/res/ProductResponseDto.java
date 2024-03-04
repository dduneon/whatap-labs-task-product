package io.whatap.task.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 상품 조회 결과를 나타내는 Response Dto 클래스
 *
 * @author 김준현
 * @version 2024. 03. 05
 */
@AllArgsConstructor
@Getter
public class ProductResponseDto {
    private Long id;
    private String name;
    private String description;
}
