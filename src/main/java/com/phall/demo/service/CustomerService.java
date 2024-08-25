package com.phall.demo.service;

import java.util.List;

import com.phall.demo.entity.Customer;

public interface CustomerService {

    List<Customer> listAll();

    Customer saveData(Customer company);

    Customer getById(Long id);

    Customer update(Long id, Customer update);

    void deleteById(Long id);

}
