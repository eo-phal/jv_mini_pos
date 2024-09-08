package com.phall.demo.service;

import java.util.List;

import com.phall.demo.entity.ExchangeRate;
import com.phall.demo.response.ExchangeRateResponse;

public interface ExchangeRateService {

    List<ExchangeRateResponse> listAll();

    ExchangeRate saveData(ExchangeRate exchangeRate);

    ExchangeRate getById(Long id);

    ExchangeRate update(Long id, ExchangeRate update);

    void deleteById(Long id);
}
