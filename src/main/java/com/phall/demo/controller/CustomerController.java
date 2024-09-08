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

import com.phall.demo.entity.Customer;
import com.phall.demo.mapper.CustomerMapper;
import com.phall.demo.request.CustomerRequest;
import com.phall.demo.response.CustomerResponse;
import com.phall.demo.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerMapper customerMapper;

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllEntity(){
        List<CustomerResponse> response =  customerService.listAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> saveData(@Valid @RequestBody CustomerRequest dto){
        Customer customer = customerMapper.toEntity(dto);
        Customer saveData = customerService.saveData(customer);

        CustomerResponse response = customerMapper.toDTO(saveData);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerResponse> getById(@PathVariable Long id){
        Customer getData =  customerService.getById(id);
        CustomerResponse response = customerMapper.toDTO(getData);
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<CustomerResponse> update(@PathVariable Long id, @RequestBody CustomerRequest dto){
        Customer customer = customerMapper.toEntity(dto);
        Customer update = customerService.update(id, customer);
        CustomerResponse response = customerMapper.toDTO(update);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        customerService.deleteById(id);
        return ResponseEntity.ok(null);
    }

    
}
