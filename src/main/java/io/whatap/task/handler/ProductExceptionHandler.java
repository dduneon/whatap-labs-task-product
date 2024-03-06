package io.whatap.task.handler;

import io.whatap.task.exception.ProductNotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import java.util.Map;

/**
 * Product 에서 발생하는 예외를 처리하는 Exception Handler 클래스
 *
 * @author 김준현
 * @version 2024. 03. 06
 */
@Provider
public class ProductExceptionHandler implements ExceptionMapper<ProductNotFoundException> {
    @Override
    public Response toResponse(ProductNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(Map.of("message", exception.getMessage()))
                .build();
    }
}
