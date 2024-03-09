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
public class ProductExceptionHandler implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception exception) {
        if (exception instanceof ProductNotFoundException) {
            return handleProductNotFoundException((ProductNotFoundException) exception);
        } else {
            return handleGenericException(exception);
        }
    }

    private Response handleProductNotFoundException(ProductNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(Map.of("status", Response.Status.NOT_FOUND.getStatusCode(), "message", exception.getMessage()))
                .build();
    }

    private Response handleGenericException(Exception exception) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(Map.of("status", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "message", exception.getMessage()))
                .build();
    }

}
