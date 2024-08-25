package com.phall.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phall.demo.entity.Customer;
import com.phall.demo.exception.ResourceNotFoundException;
import com.phall.demo.repository.CustomerRepository;
import com.phall.demo.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> listAll(){
        return customerRepository.findAll();
    }

    @Override
    public Customer saveData(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Company", id));
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
