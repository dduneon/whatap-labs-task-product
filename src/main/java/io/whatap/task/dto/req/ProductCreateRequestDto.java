package io.whatap.task.dto.req;

import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Name 은 반드시 입력되어야 합니다")
    private String name;
    @NotBlank(message = "Description 은 반드시 입력되어야 합니다")
    private String description;
}
