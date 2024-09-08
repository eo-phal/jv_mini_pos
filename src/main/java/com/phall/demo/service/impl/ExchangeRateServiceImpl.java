package com.phall.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phall.demo.entity.ExchangeRate;
import com.phall.demo.exception.ResourceNotFoundException;
import com.phall.demo.mapper.ExchangeRateMapper;
import com.phall.demo.repository.ExchangeRateRepository;
import com.phall.demo.response.ExchangeRateResponse;
import com.phall.demo.service.ExchangeRateService;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService{

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @Autowired 
    private ExchangeRateMapper exchangeRateMapper;

    public List<ExchangeRateResponse> listAll(){
        return exchangeRateRepository.findAll().stream().map(exchangeRateMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ExchangeRate saveData(ExchangeRate exchangeRate){
        return exchangeRateRepository.save(exchangeRate);
    }

    public ExchangeRate getById(Long id){
        return exchangeRateRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Exchange rate", id));
    }

    @Override
    public ExchangeRate update(Long id, ExchangeRate update) {
        ExchangeRate dataUpdate = getById(id);
        dataUpdate.setExchangeRate(update.getExchangeRate());
        return exchangeRateRepository.save(dataUpdate);
    }

    @Override
    public void deleteById(Long id) {
        ExchangeRate byId = getById(id);
        exchangeRateRepository.delete(byId);
    }
}
