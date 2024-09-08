package com.phall.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phall.demo.entity.Supplier;
import com.phall.demo.mapper.SupplierMapper;
import com.phall.demo.request.SupplierRequest;
import com.phall.demo.response.SupplierResponse;
import com.phall.demo.service.SupplierService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @Autowired
    private SupplierMapper supplierMapper;

    @GetMapping
    public ResponseEntity<List<SupplierResponse>> getAllEntity(){
        List<SupplierResponse> response =  supplierService.listAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<SupplierResponse> saveData(@Valid @RequestBody SupplierRequest dto){
        Supplier supplier = supplierMapper.toEntity(dto);
        Supplier saveData = supplierService.saveData(supplier);

        SupplierResponse response = supplierMapper.toDTO(saveData);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<SupplierResponse> getById(@PathVariable Long id){
        Supplier getData =  supplierService.getById(id);
        SupplierResponse response = supplierMapper.toDTO(getData);
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<SupplierResponse> update(@PathVariable Long id, @RequestBody SupplierRequest dto){
        Supplier supplier = supplierMapper.toEntity(dto);
        Supplier update = supplierService.update(id, supplier);
        SupplierResponse response = supplierMapper.toDTO(update);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        supplierService.deleteById(id);
        return ResponseEntity.ok(null);
    }

    
}
