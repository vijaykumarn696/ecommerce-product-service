package dev.vijay.productservice.controllers;

import dev.vijay.productservice.dtos.GenericProductDto;
import dev.vijay.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService)
    {
        this.productService=productService;
    }
    @GetMapping("{id}")
    public GenericProductDto getAllProductsById(@PathVariable("id") Long id)
    {
        return productService.getProductsById(id);
    }
}
