package com.phall.demo.service;

import java.util.List;

import com.phall.demo.entity.Supplier;

public interface SupplierService {

    List<Supplier> listAll();

    Supplier saveData(Supplier company);

    Supplier getById(Long id);

    Supplier update(Long id, Supplier update);

    void deleteById(Long id);

}
