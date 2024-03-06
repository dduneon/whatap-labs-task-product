package io.whatap.task.controller;

import io.quarkus.panache.common.Page;
import io.whatap.task.dto.req.ProductCreateRequestDto;
import io.whatap.task.dto.req.ProductUpdateRequestDto;
import io.whatap.task.dto.res.ProductResponseDto;
import io.whatap.task.service.ProductService;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * 상품 API 를 제공하는 Product REST Controller
 *
 * @author 김준현
 * @version 2024. 03. 05
 */

@Produces(MediaType.APPLICATION_JSON)
@Path("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * productId 에 해당하는 상품에 대한 정보를 가져오는 요청을 받는 메서드
     * @param productId 상품의 아이디
     * @return 상품 정보(아이디, 이름, 설명), 존재한다면 OK, 존재하지 않다면 NOT FOUND
     */
    @GET
    @Path("/{productId}")
    public Response getProduct(@PathParam("productId") Long productId) {
        ProductResponseDto foundProduct = productService.readProduct(productId);
        return Response.ok(foundProduct).build();
    }

    /**
     * 전체 상품을 페이징 처리 후, 사용자에게 리스트 형태로 반환하는 메서드
     * @param page 원하는 페이지 (초기 값: 0)
     * @param size 원하는 사이즈 (초기 값: 5)
     * @return 페이징 처리 된 상품의 리스트
     */
    @GET
    public Response getProductsByPagination(@QueryParam("page") @DefaultValue("0") int page,
                                            @QueryParam("size") @DefaultValue("5") int size) {
        return Response.ok(productService.readProductPagination(Page.of(page, size))).build();
    }

    /**
     * 사용자로부터 상품을 생성 요청을 받는 메서드
     * @param productCreateRequestDto 상품 생성을 위한 정보를 담은 Dto
     * @return 생성되었다면 CREATED, 상품이 존재하지 않다면 NOT FOUND
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProduct(@Valid ProductCreateRequestDto productCreateRequestDto) {
        productService.createProduct(productCreateRequestDto);
        return Response.status(Response.Status.CREATED).build();
    }

    /**
     * 사용자로부터 상품 수정 요청을 받는 메서드
     * @param productUpdateRequestDto 상품 수정을 위한 정보를 담은 Dto
     * @return 수정되었다면 No Content, 상품이 존재하지 않다면 NOT FOUND
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProduct(@Valid ProductUpdateRequestDto productUpdateRequestDto) {
        productService.updateProduct(productUpdateRequestDto);
        return Response.noContent().build();
    }

    /**
     * 사용자로부터 상품 삭제 요청을 받는 메서드
     * @param productId 삭제할 상품 아이디
     * @return 삭제되었다면 No Content, 상품이 존재하지 않다면 NOT FOUND
     */
    @DELETE
    @Path("/{productId}")
    public Response deleteProduct(@PathParam("productId") Long productId) {
        productService.deleteProduct(productId);
        return Response.noContent().build();
    }


}
