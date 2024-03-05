package io.whatap.task.controller;

import io.quarkus.panache.common.Sort;
import io.whatap.task.dto.req.ProductCreateRequestDto;
import io.whatap.task.dto.req.ProductUpdateRequestDto;
import io.whatap.task.entity.Product;
import io.whatap.task.service.ProductService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Objects;

/**
 * 상품 API 를 제공하는 Product REST Controller
 *
 * @author 김준현
 * @version 2024. 03. 05
 */

@Path("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GET
    @Path("/{productId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(@PathParam("productId") Long productId) {
        Product product = Product.findById(productId);
        if(Objects.isNull(product))
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(product).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductsByPagination(@QueryParam("page") int page, @QueryParam("size") int size) {
        return Response.ok(Product.findAll(Sort.by("id")).page(page, size).list()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProduct(@Valid ProductCreateRequestDto productCreateRequestDto) {
        productService.createProduct(productCreateRequestDto);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProduct(@Valid ProductUpdateRequestDto productUpdateRequestDto) {
        Product product = Product.findById(productUpdateRequestDto.getId());
        product.updateProductName(productUpdateRequestDto.getName());
        product.updateProductDescription(productUpdateRequestDto.getDescription());
        return Response.ok().build();
    }

    @DELETE
    @Transactional
    @Path("/{productId}")
    public Response deleteProduct(@PathParam("productId") Long productId) {
        return Response.ok(Product.deleteById(productId)).build();
    }
}
