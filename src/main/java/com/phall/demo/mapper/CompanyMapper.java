package com.phall.demo.mapper;

import com.phall.demo.dto.CompanyDTO;
import com.phall.demo.entity.Company;

public class CompanyMapper {
    public static Company toCompany(CompanyDTO entity){
        Company company = new Company();
        company.setCompanyLocalName(entity.getCompanyLocalName());
        company.setCompanyEngName(entity.getCompanyEngName());
        company.setCompanyEmail(entity.getCompanyEmail());
        company.setCompanyPhone(entity.getCompanyPhone());
        company.setCompanyAddress(entity.getCompanyAddress());
        company.setVatNumber(entity.getVatNumber());
        company.setImagePath(entity.getImagePath());
        company.setImage(entity.getImage());
        return company;
    }

    public static CompanyDTO toDTO(Company entity){
        CompanyDTO dto = new CompanyDTO();
        dto.setCompanyLocalName(entity.getCompanyLocalName());
        dto.setCompanyEngName(entity.getCompanyEngName());
        dto.setCompanyEmail(entity.getCompanyEmail());
        dto.setCompanyPhone(entity.getCompanyPhone());
        dto.setCompanyAddress(entity.getCompanyAddress());
        dto.setVatNumber(entity.getVatNumber());
        dto.setImagePath(entity.getImagePath());
        dto.setImage(entity.getImage());
        return dto;
    }
}
