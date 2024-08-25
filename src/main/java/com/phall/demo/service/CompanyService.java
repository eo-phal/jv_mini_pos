package com.phall.demo.service;

import java.util.List;

import com.phall.demo.entity.Company;

public interface CompanyService {

    List<Company> listAll();

    Company saveData(Company company);

    Company getById(Long id);

    Company update(Long id, Company update);

    void deleteById(Long id);

}
