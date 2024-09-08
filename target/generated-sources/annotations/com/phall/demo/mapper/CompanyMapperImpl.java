package com.phall.demo.mapper;

import com.phall.demo.entity.Company;
import com.phall.demo.request.CompanyRequest;
import com.phall.demo.response.CompanyResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-08T21:48:56+0700",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class CompanyMapperImpl implements CompanyMapper {

    @Override
    public Company toEntity(CompanyRequest request) {
        if ( request == null ) {
            return null;
        }

        Company company = new Company();

        company.setCompanyAddress( request.getCompanyAddress() );
        company.setCompanyEmail( request.getCompanyEmail() );
        company.setCompanyEngName( request.getCompanyEngName() );
        company.setCompanyLocalName( request.getCompanyLocalName() );
        company.setCompanyPhone( request.getCompanyPhone() );
        company.setImage( request.getImage() );
        company.setImagePath( request.getImagePath() );
        company.setVatNumber( request.getVatNumber() );

        return company;
    }

    @Override
    public CompanyResponse toDTO(Company company) {
        if ( company == null ) {
            return null;
        }

        CompanyResponse companyResponse = new CompanyResponse();

        companyResponse.setCompanyAddress( company.getCompanyAddress() );
        companyResponse.setCompanyEmail( company.getCompanyEmail() );
        companyResponse.setCompanyEngName( company.getCompanyEngName() );
        companyResponse.setCompanyLocalName( company.getCompanyLocalName() );
        companyResponse.setCompanyPhone( company.getCompanyPhone() );
        if ( company.getId() != null ) {
            companyResponse.setId( company.getId().intValue() );
        }
        companyResponse.setImage( company.getImage() );
        companyResponse.setImagePath( company.getImagePath() );
        companyResponse.setVatNumber( company.getVatNumber() );

        return companyResponse;
    }
}
