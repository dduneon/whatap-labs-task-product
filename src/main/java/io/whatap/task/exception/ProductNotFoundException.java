package io.whatap.task.exception;

/**
 * 상품이 존재하지 않을 때 발생하는 예외 클래스
 *
 * @author 김준현
 * @version 2024. 03. 06
 */
public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Long id) {
        super(String.format("Product(id=%d) 를 찾을 수 없습니다", id));
    }
}
