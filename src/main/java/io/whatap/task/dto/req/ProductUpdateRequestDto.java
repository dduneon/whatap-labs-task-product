package io.whatap.task.dto.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * description
 *
 * @author 김준현
 * @version 2024. 03. 06
 */
@NoArgsConstructor
@Getter
public class ProductUpdateRequestDto {
    @NotNull(message = "ID 가 비어 있습니다")
    private Long id;
    @NotBlank(message = "Name 은 반드시 입력되어야 합니다")
    private String name;
    @NotBlank(message = "Description 은 반드시 입력되어야 합니다")
    private String description;
}
