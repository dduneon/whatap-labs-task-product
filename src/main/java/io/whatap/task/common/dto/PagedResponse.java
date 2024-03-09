package io.whatap.task.common.dto;

import io.whatap.task.common.domain.PageInfo;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Paging 된 객체와 Page 정보를 담는 클래스
 *
 * @author 김준현
 * @version 2024. 03. 10
 */
@AllArgsConstructor
@Getter
public class PagedResponse<T> {
    private List<T> data;
    private PageInfo pageInfo;
}