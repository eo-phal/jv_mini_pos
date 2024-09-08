package com.phall.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phall.demo.entity.Supplier;
import com.phall.demo.exception.ResourceNotFoundException;
import com.phall.demo.mapper.SupplierMapper;
import com.phall.demo.repository.SupplierRepository;
import com.phall.demo.response.SupplierResponse;
import com.phall.demo.service.SupplierService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService{
    
    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired 
    private SupplierMapper supplierMapper;
    public List<SupplierResponse> listAll(){
        return supplierRepository.findAll().stream().map(supplierMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Supplier saveData(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier getById(Long id) {
        return supplierRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Supplier", id));
    }

    @Override
    public Supplier update(Long id, Supplier update) {
        Supplier dataUpdate = getById(id);
        dataUpdate.setSupplierLocalName(update.getSupplierLocalName());
        dataUpdate.setSupplierEngName(update.getSupplierEngName());
        dataUpdate.setSupplierEmail(update.getSupplierEmail());
        dataUpdate.setSupplierPhone(update.getSupplierPhone());
        dataUpdate.setSupplierVatNumber(update.getSupplierVatNumber());
        
        return supplierRepository.save(dataUpdate);
    }

    @Override
    public void deleteById(Long id) {
        Supplier byId = getById(id);
        supplierRepository.delete(byId);
    }
    
}   
