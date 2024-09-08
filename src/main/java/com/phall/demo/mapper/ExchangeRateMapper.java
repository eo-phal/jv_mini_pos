package com.phall.demo.mapper;

import org.mapstruct.Mapper;

import com.phall.demo.entity.ExchangeRate;
import com.phall.demo.request.ExchangeRateRequest;
import com.phall.demo.response.ExchangeRateResponse;

@Mapper(componentModel = "spring")
public interface ExchangeRateMapper {

    ExchangeRate toEntity(ExchangeRateRequest request);
    ExchangeRateResponse toDTO(ExchangeRate entity);
    
}
