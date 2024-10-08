package com.phall.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phall.demo.entity.Company;
import com.phall.demo.exception.ResourceNotFoundException;
import com.phall.demo.mapper.CompanyMapper;
import com.phall.demo.repository.CompanyRepository;
import com.phall.demo.response.CompanyResponse;
import com.phall.demo.service.CompanyService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService{
    
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyMapper companyMapper;

    public List<CompanyResponse> listAll(){
        return companyRepository.findAll().stream().map(companyMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Company saveData(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company getById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Company", id));
    }

    @Override
    public Company update(Long id, Company update) {
        Company dataUpdate = getById(id);
        dataUpdate.setCompanyLocalName(update.getCompanyLocalName());
        dataUpdate.setCompanyEngName(update.getCompanyEngName());
        dataUpdate.setCompanyEmail(update.getCompanyEmail());
        dataUpdate.setCompanyPhone(update.getCompanyPhone());
        dataUpdate.setVatNumber(update.getVatNumber());
        dataUpdate.setImage(update.getImage());
        dataUpdate.setImagePath(update.getImagePath());
        return companyRepository.save(dataUpdate);
    }

    @Override
    public void deleteById(Long id) {
        Company byId = getById(id);
        companyRepository.delete(byId);
    }

}   
