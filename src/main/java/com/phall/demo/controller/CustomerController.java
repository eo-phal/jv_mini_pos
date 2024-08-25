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

import com.phall.demo.dto.CustomerDTO;
import com.phall.demo.entity.Customer;
import com.phall.demo.mapper.CustomerMapper;
import com.phall.demo.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<?> getAllEntity(){
        List<Customer> listAll =  customerService.listAll();
        return ResponseEntity.ok(listAll);
    }

    @PostMapping
    public ResponseEntity<?> saveData(@RequestBody CustomerDTO dto){
        Customer customer = CustomerMapper.toCustomer(dto);
        Customer saveData = customerService.saveData(customer);

        CustomerDTO dto2 = CustomerMapper.toDTO(saveData);
        return ResponseEntity.ok(dto2);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Customer getData =  customerService.getById(id);
        CustomerDTO dto = CustomerMapper.toDTO(getData);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CustomerDTO dto){
        Customer customer = CustomerMapper.toCustomer(dto);
        Customer update = customerService.update(id, customer);
        CustomerDTO dataUpdate = CustomerMapper.toDTO(update);
        return ResponseEntity.ok(dataUpdate);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        customerService.deleteById(id);
        return ResponseEntity.ok(null);
    }

    
}
