package com.phall.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phall.demo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
