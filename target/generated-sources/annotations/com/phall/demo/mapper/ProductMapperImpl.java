package com.phall.demo.mapper;

import com.phall.demo.entity.Product;
import com.phall.demo.request.ProductRequest;
import com.phall.demo.response.ProductResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-08T21:49:26+0700",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toEntity(ProductRequest request) {
        if ( request == null ) {
            return null;
        }

        Product product = new Product();

        product.setTitle( request.getTitle() );

        return product;
    }

    @Override
    public ProductResponse toDTO(Product entity) {
        if ( entity == null ) {
            return null;
        }

        ProductResponse productResponse = new ProductResponse();

        productResponse.setId( entity.getId() );
        productResponse.setTitle( entity.getTitle() );

        return productResponse;
    }
}
