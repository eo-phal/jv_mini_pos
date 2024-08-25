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

import com.phall.demo.dto.SupplierDTO;
import com.phall.demo.entity.Supplier;
import com.phall.demo.mapper.SupplierMapper;
import com.phall.demo.service.SupplierService;

@RestController
@RequestMapping("supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public ResponseEntity<?> getAllEntity(){
        List<Supplier> listAll =  supplierService.listAll();
        return ResponseEntity.ok(listAll);
    }

    @PostMapping
    public ResponseEntity<?> saveData(@RequestBody SupplierDTO dto){
        Supplier supplier = SupplierMapper.toSupplier(dto);
        Supplier saveData = supplierService.saveData(supplier);

        SupplierDTO dto2 = SupplierMapper.toDTO(saveData);
        return ResponseEntity.ok(dto2);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Supplier getData =  supplierService.getById(id);
        SupplierDTO dto = SupplierMapper.toDTO(getData);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody SupplierDTO dto){
        Supplier supplier = SupplierMapper.toSupplier(dto);
        Supplier update = supplierService.update(id, supplier);
        SupplierDTO dataUpdate = SupplierMapper.toDTO(update);
        return ResponseEntity.ok(dataUpdate);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        supplierService.deleteById(id);
        return ResponseEntity.ok(null);
    }

    
}
