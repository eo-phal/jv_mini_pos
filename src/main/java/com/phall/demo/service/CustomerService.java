package com.phall.demo.service;

import java.util.List;

import com.phall.demo.entity.Customer;
import com.phall.demo.response.CustomerResponse;

public interface CustomerService {

    List<CustomerResponse> listAll();

    Customer saveData(Customer company);

    Customer getById(Long id);

    Customer update(Long id, Customer update);

    void deleteById(Long id);

}
