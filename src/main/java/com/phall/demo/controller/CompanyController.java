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

import com.phall.demo.dto.CompanyDTO;
import com.phall.demo.entity.Company;
import com.phall.demo.mapper.CompanyMapper;
import com.phall.demo.service.CompanyService;

@RestController
@RequestMapping("company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    public ResponseEntity<?> getAllEntity(){
        List<Company> listAll =  companyService.listAll();
        return ResponseEntity.ok(listAll);
    }

    @PostMapping
    public ResponseEntity<?> saveData(@RequestBody CompanyDTO dto){
        Company company = CompanyMapper.toCompany(dto);
        Company saveData = companyService.saveData(company);

        CompanyDTO dto2 = CompanyMapper.toDTO(saveData);
        return ResponseEntity.ok(dto2);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Company getData =  companyService.getById(id);
        CompanyDTO dto = CompanyMapper.toDTO(getData);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CompanyDTO dto){
        Company company = CompanyMapper.toCompany(dto);
        Company update = companyService.update(id, company);
        CompanyDTO dataUpdate = CompanyMapper.toDTO(update);
        return ResponseEntity.ok(dataUpdate);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        companyService.deleteById(id);
        return ResponseEntity.ok(null);
    }

    
}
