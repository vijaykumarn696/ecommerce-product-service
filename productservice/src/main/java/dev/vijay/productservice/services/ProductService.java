package dev.vijay.productservice.services;

import dev.vijay.productservice.dtos.GenericProductDto;

public interface ProductService {
   public GenericProductDto getProductsById(Long id);
}
