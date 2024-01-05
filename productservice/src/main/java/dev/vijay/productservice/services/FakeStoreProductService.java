package dev.vijay.productservice.services;

import dev.vijay.productservice.dtos.FakeStoreProductDto;
import dev.vijay.productservice.dtos.GenericProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private String getProductUrl="https://fakestoreapi.com/products/{id}";
    private RestTemplateBuilder restTemplateBuilder;
    @Autowired
    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder)
    {
        this.restTemplateBuilder=restTemplateBuilder;
    }
    @Override
    public GenericProductDto getProductsById(Long id) {
       RestTemplate restTemplate= restTemplateBuilder.build();
       ResponseEntity<FakeStoreProductDto> response=restTemplate.getForEntity(getProductUrl, FakeStoreProductDto.class,id);
       FakeStoreProductDto fakeStoreProductDto=response.getBody();
       GenericProductDto genericProductDto=new GenericProductDto();
       genericProductDto.setId(fakeStoreProductDto.getId());
       genericProductDto.setTitle(fakeStoreProductDto.getTitle());
       genericProductDto.setCategory(fakeStoreProductDto.getCategory());
       genericProductDto.setPrice(fakeStoreProductDto.getPrice());
       genericProductDto.setImage(fakeStoreProductDto.getImage());
       genericProductDto.setDescription(fakeStoreProductDto.getDescription());

       return genericProductDto;
    }
}
