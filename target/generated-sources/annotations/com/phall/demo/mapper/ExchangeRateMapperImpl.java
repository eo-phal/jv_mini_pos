package com.phall.demo.mapper;

import com.phall.demo.entity.ExchangeRate;
import com.phall.demo.request.ExchangeRateRequest;
import com.phall.demo.response.ExchangeRateResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-08T21:49:12+0700",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class ExchangeRateMapperImpl implements ExchangeRateMapper {

    @Override
    public ExchangeRate toEntity(ExchangeRateRequest request) {
        if ( request == null ) {
            return null;
        }

        ExchangeRate exchangeRate = new ExchangeRate();

        exchangeRate.setExchangeRate( request.getExchangeRate() );

        return exchangeRate;
    }

    @Override
    public ExchangeRateResponse toDTO(ExchangeRate entity) {
        if ( entity == null ) {
            return null;
        }

        ExchangeRateResponse exchangeRateResponse = new ExchangeRateResponse();

        exchangeRateResponse.setExchangeRate( entity.getExchangeRate() );
        if ( entity.getId() != null ) {
            exchangeRateResponse.setId( entity.getId().intValue() );
        }

        return exchangeRateResponse;
    }
}
