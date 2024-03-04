package io.whatap.task.dto.req;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 상품 생성을 위한 Request Dto 클래스
 *
 * @author 김준현
 * @version 2024. 03. 05
 */

@NoArgsConstructor
@Getter
public class ProductCreateRequestDto {
    private String name;
    private String description;
}
