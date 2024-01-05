package dev.vijay.productservice.services;

import dev.vijay.productservice.dtos.GenericProductDto;
import org.springframework.stereotype.Service;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService {
    @Override
    public GenericProductDto getProductsById(Long id) {
        return null;
    }
}
