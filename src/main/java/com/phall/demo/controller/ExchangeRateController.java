package com.phall.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phall.demo.entity.ExchangeRate;
import com.phall.demo.mapper.ExchangeRateMapper;
import com.phall.demo.request.ExchangeRateRequest;
import com.phall.demo.response.ExchangeRateResponse;
import com.phall.demo.service.ExchangeRateService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("exchange-rate")
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @Autowired
    private ExchangeRateMapper exchangeRateMapper;
        
    @GetMapping
    public ResponseEntity<List<ExchangeRateResponse>> getAllEntity(){
        List<ExchangeRateResponse> response = exchangeRateService.listAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ExchangeRateResponse> saveData(@Valid @RequestBody ExchangeRateRequest dto){
        ExchangeRate exchangeRate = exchangeRateMapper.toEntity(dto);
        ExchangeRate saveData = exchangeRateService.saveData(exchangeRate);

        ExchangeRateResponse response = exchangeRateMapper.toDTO(saveData);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<ExchangeRateResponse> getById(@PathVariable Long id){
        ExchangeRate getData = exchangeRateService.getById(id);
        ExchangeRateResponse response = exchangeRateMapper.toDTO(getData);
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<ExchangeRateResponse> update(@PathVariable Long id, @Valid @RequestBody ExchangeRateRequest dto){
        ExchangeRate exchangeRate = exchangeRateMapper.toEntity(dto);
        ExchangeRate update = exchangeRateService.update(id, exchangeRate);
        ExchangeRateResponse response = exchangeRateMapper.toDTO(update);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        exchangeRateService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
