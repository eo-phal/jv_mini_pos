package com.phall.demo.mapper;

import com.phall.demo.entity.Supplier;
import com.phall.demo.request.SupplierRequest;
import com.phall.demo.response.SupplierResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-08T21:49:35+0700",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class SupplierMapperImpl implements SupplierMapper {

    @Override
    public Supplier toEntity(SupplierRequest request) {
        if ( request == null ) {
            return null;
        }

        Supplier supplier = new Supplier();

        supplier.setSupplierAddress( request.getSupplierAddress() );
        supplier.setSupplierEmail( request.getSupplierEmail() );
        supplier.setSupplierEngName( request.getSupplierEngName() );
        supplier.setSupplierLocalName( request.getSupplierLocalName() );
        supplier.setSupplierPhone( request.getSupplierPhone() );
        supplier.setSupplierVatNumber( request.getSupplierVatNumber() );

        return supplier;
    }

    @Override
    public SupplierResponse toDTO(Supplier entity) {
        if ( entity == null ) {
            return null;
        }

        SupplierResponse supplierResponse = new SupplierResponse();

        if ( entity.getId() != null ) {
            supplierResponse.setId( entity.getId().intValue() );
        }
        supplierResponse.setSupplierAddress( entity.getSupplierAddress() );
        supplierResponse.setSupplierEmail( entity.getSupplierEmail() );
        supplierResponse.setSupplierEngName( entity.getSupplierEngName() );
        supplierResponse.setSupplierLocalName( entity.getSupplierLocalName() );
        supplierResponse.setSupplierPhone( entity.getSupplierPhone() );
        supplierResponse.setSupplierVatNumber( entity.getSupplierVatNumber() );

        return supplierResponse;
    }
}
