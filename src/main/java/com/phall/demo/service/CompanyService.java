package com.phall.demo.service;

import java.util.List;

import com.phall.demo.entity.Company;
import com.phall.demo.response.CompanyResponse;

public interface CompanyService {

    List<CompanyResponse> listAll();

    Company saveData(Company company);

    Company getById(Long id);

    Company update(Long id, Company update);

    void deleteById(Long id);

}
