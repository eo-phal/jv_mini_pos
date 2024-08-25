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

import com.phall.demo.dto.ExchangeRateDTO;
import com.phall.demo.entity.ExchangeRate;
import com.phall.demo.mapper.ExchangeRateMapper;
import com.phall.demo.service.ExchangeRateService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("exchange-rate")
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService exchangeRateService;
        
    @GetMapping
    public ResponseEntity<?> getAllEntity(){
        List<ExchangeRate> listAll = exchangeRateService.listAll();
        return ResponseEntity.ok(listAll);
    }

    @PostMapping
    public ResponseEntity<?> saveData(@Valid @RequestBody ExchangeRateDTO dto){
        ExchangeRate exchangeRate = ExchangeRateMapper.toBranch(dto);
        ExchangeRate saveData = exchangeRateService.saveData(exchangeRate);

        ExchangeRateDTO dto2 = ExchangeRateMapper.toDTO(saveData);
        return ResponseEntity.ok(dto2);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        ExchangeRate getData = exchangeRateService.getById(id);
        ExchangeRateDTO dto = ExchangeRateMapper.toDTO(getData);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ExchangeRateDTO dto){
        ExchangeRate exchangeRate = ExchangeRateMapper.toBranch(dto);
        ExchangeRate update = exchangeRateService.update(id, exchangeRate);
        ExchangeRateDTO dataUpdate = ExchangeRateMapper.toDTO(update);
        return ResponseEntity.ok(dataUpdate);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        exchangeRateService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
