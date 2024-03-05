package io.whatap.task.controller;

import io.whatap.task.dto.req.ProductCreateRequestDto;
import io.whatap.task.dto.res.ProductResponseDto;
import io.whatap.task.entity.Product;
import io.whatap.task.service.ProductService;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

/**
 * 상품 API 를 제공하는 Product REST Controller
 *
 * @author 김준현
 * @version 2024. 03. 05
 */

@Path("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    // Annotation 해도 되고 안해도 됨
//    @Inject
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }

    @GET
    @Path("/{productId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(@PathParam("productId") Long productId) {
        ProductResponseDto productResponseDto = productService.readProduct(productId);
        return Response.ok(productResponseDto)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProduct(ProductCreateRequestDto productCreateRequestDto) {
//        productService.createProduct(productCreateRequestDto);
        Product product = Product.builder()
                .name(productCreateRequestDto.getName())
                .description(productCreateRequestDto.getDescription())
                .build();
        product.persist();
        return Response.status(Response.Status.CREATED).build();
    }
}
