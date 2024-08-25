package com.phall.demo.mapper;

import com.phall.demo.dto.CustomerDTO;
import com.phall.demo.entity.Customer;

public class CustomerMapper {
    public static Customer toCustomer(CustomerDTO entity){
        Customer customer = new Customer();
        customer.setCustomerLocalName(entity.getCustomerLocalName());
        customer.setCustomerEngName(entity.getCustomerEngName());
        customer.setCustomerEmail(entity.getCustomerEmail());
        customer.setCustomerPhone(entity.getCustomerPhone());
        customer.setCustomerAddress(entity.getCustomerAddress());
        return customer;
    }

    public static CustomerDTO toDTO(Customer entity){
        CustomerDTO dto = new CustomerDTO();
        dto.setCustomerLocalName(entity.getCustomerLocalName());
        dto.setCustomerEngName(entity.getCustomerEngName());
        dto.setCustomerEmail(entity.getCustomerEmail());
        dto.setCustomerPhone(entity.getCustomerPhone());
        dto.setCustomerAddress(entity.getCustomerAddress());
        return dto;
    }
}
