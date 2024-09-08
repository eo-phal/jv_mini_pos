package com.phall.demo.mapper;

import org.mapstruct.Mapper;

import com.phall.demo.entity.Customer;
import com.phall.demo.request.CustomerRequest;
import com.phall.demo.response.CustomerResponse;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toEntity(CustomerRequest request);
    CustomerResponse toDTO(Customer customer);
    
}
