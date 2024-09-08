package com.phall.demo.mapper;

import org.mapstruct.Mapper;

import com.phall.demo.entity.Company;
import com.phall.demo.request.CompanyRequest;
import com.phall.demo.response.CompanyResponse;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    Company toEntity(CompanyRequest request);
    CompanyResponse toDTO(Company company);
    
} 