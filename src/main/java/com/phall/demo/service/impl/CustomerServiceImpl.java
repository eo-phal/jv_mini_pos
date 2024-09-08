package com.phall.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phall.demo.entity.Customer;
import com.phall.demo.exception.ResourceNotFoundException;
import com.phall.demo.mapper.CustomerMapper;
import com.phall.demo.repository.CustomerRepository;
import com.phall.demo.response.CustomerResponse;
import com.phall.demo.service.CustomerService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService{
    
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    public List<CustomerResponse> listAll(){
        return customerRepository.findAll().stream().map(customerMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Customer saveData(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Customer", id));
    }

    @Override
    public Customer update(Long id, Customer update) {
        Customer dataUpdate = getById(id);
        dataUpdate.setCustomerLocalName(update.getCustomerLocalName());
        dataUpdate.setCustomerEngName(update.getCustomerEngName());
        dataUpdate.setCustomerEmail(update.getCustomerEmail());
        dataUpdate.setCustomerPhone(update.getCustomerPhone());
        
        return customerRepository.save(dataUpdate);
    }

    @Override
    public void deleteById(Long id) {
        Customer byId = getById(id);
        customerRepository.delete(byId);
    }
    
}   
