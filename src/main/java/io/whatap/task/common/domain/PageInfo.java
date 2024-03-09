package io.whatap.task.common.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * Page 정보에 관한 정보를 저장하는 클래스
 *
 * @author 김준현
 * @version 2024. 03. 10
 */
@AllArgsConstructor
@Builder
@Getter
public class PageInfo {
    private int page;
    private int size;
    private int totalElements;
    private int totalPages;
}
