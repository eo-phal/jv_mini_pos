package com.phall.demo.service;

import java.util.List;

import com.phall.demo.entity.ExchangeRate;

public interface ExchangeRateService {

    List<ExchangeRate> listAll();

    ExchangeRate saveData(ExchangeRate exchangeRate);

    ExchangeRate getById(Long id);

    ExchangeRate update(Long id, ExchangeRate update);

    void deleteById(Long id);
}
