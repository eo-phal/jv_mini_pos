package com.phall.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "local_name")
    private String customerLocalName;

    @Column(name = "eng_name")
    private String customerEngName;

    @Column(name = "email")
    private String customerEmail;

    @Column(name = "phone")
    private String customerPhone;

    @Column(name = "address")
    private String customerAddress;

}
