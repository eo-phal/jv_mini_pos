package com.phall.demo.mapper;

import com.phall.demo.dto.ExchangeRateDTO;
import com.phall.demo.entity.ExchangeRate;

public class ExchangeRateMapper {
    public static ExchangeRate toBranch(ExchangeRateDTO dto){
        ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.setExchangeRate(dto.getExchangeRate());
        return exchangeRate;
    }

    public static ExchangeRateDTO toDTO(ExchangeRate entity){
        ExchangeRateDTO dto = new ExchangeRateDTO();
        dto.setExchangeRate(entity.getExchangeRate());
        return dto;
    }
}
