package com.phall.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phall.demo.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

}
