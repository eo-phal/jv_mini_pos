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


import com.phall.demo.entity.Company;
import com.phall.demo.mapper.CompanyMapper;
import com.phall.demo.request.CompanyRequest;
import com.phall.demo.response.CompanyResponse;
import com.phall.demo.service.CompanyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyMapper companyMapper;

    @GetMapping
    public ResponseEntity<List<CompanyResponse>> getAllEntity(){
        List<CompanyResponse> response =  companyService.listAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CompanyResponse> saveData(@Valid @RequestBody CompanyRequest dto){
        Company company = companyMapper.toEntity(dto);
        Company saveData = companyService.saveData(company);

        CompanyResponse response = companyMapper.toDTO(saveData);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<CompanyResponse> getById(@PathVariable Long id){
        Company getData =  companyService.getById(id);
        CompanyResponse response = companyMapper.toDTO(getData);
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody CompanyRequest dto){
        Company company = companyMapper.toEntity(dto);
        Company update = companyService.update(id, company);
        CompanyResponse response = companyMapper.toDTO(update);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        companyService.deleteById(id);
        return ResponseEntity.ok(null);
    }

    
}
