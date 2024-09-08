package com.phall.demo.mapper;

import org.mapstruct.Mapper;

import com.phall.demo.entity.Supplier;
import com.phall.demo.request.SupplierRequest;
import com.phall.demo.response.SupplierResponse;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    Supplier toEntity(SupplierRequest request);
    SupplierResponse toDTO(Supplier entity);

}
