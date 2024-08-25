package com.phall.demo.mapper;

import com.phall.demo.dto.SupplierDTO;
import com.phall.demo.entity.Supplier;

public class SupplierMapper {
    public static Supplier toSupplier(SupplierDTO entity){
        Supplier supplier = new Supplier();
        supplier.setSupplierLocalName(entity.getSupplierLocalName());
        supplier.setSupplierEngName(entity.getSupplierEngName());
        supplier.setSupplierEmail(entity.getSupplierEmail());
        supplier.setSupplierPhone(entity.getSupplierPhone());
        supplier.setSupplierAddress(entity.getSupplierAddress());
        supplier.setSupplierVatNumber(entity.getSupplierVatNumber());
        return supplier;
    }

    public static SupplierDTO toDTO(Supplier entity){
        SupplierDTO dto = new SupplierDTO();
        dto.setSupplierLocalName(entity.getSupplierLocalName());
        dto.setSupplierEngName(entity.getSupplierEngName());
        dto.setSupplierEmail(entity.getSupplierEmail());
        dto.setSupplierPhone(entity.getSupplierPhone());
        dto.setSupplierAddress(entity.getSupplierAddress());
        dto.setSupplierVatNumber(entity.getSupplierVatNumber());
        return dto;
    }
}
