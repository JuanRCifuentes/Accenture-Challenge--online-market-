package com.accenture.accchallenge.web.controller;

import com.accenture.accchallenge.domain.service.ProductService;
import com.accenture.accchallenge.persistence.entity.Product;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    @ApiOperation("Gets a product witn a productID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Product NOT Found")
    })
    public ResponseEntity<Product> getProductById(@RequestBody List<Integer> products, @ApiParam(value = "The id of the product", required = true, example = "0") @RequestParam(value = "id") int id){
        return new ResponseEntity(productService.getProductById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    @ApiOperation("Get all Orders")
    @ApiResponse(code=200, message="OK")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity(productService.getAllProducts(), HttpStatus.OK);
    }
}