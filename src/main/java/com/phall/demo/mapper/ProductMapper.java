package com.phall.demo.mapper;

import org.mapstruct.Mapper;

import com.phall.demo.entity.Product;
import com.phall.demo.request.ProductRequest;
import com.phall.demo.response.ProductResponse;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductRequest request);

    ProductResponse toDTO(Product entity);
}
