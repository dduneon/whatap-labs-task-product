package io.whatap.task.controller;

import io.whatap.task.dto.res.ProductResponseDto;
import io.whatap.task.service.ProductService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * 상품 API 를 제공하는 Product REST Controller
 *
 * @author 김준현
 * @version 2024. 03. 05
 */

@Path("/products")
public class ProductController {
    @Inject
    ProductService productService;

    @GET
    @Path("/{productId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getProduct(@PathParam("productId") Long productId) {
        ProductResponseDto productResponseDto = productService.readProduct(productId);
        return Response.ok(productResponseDto)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
