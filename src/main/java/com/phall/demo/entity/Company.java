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
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long id;

    @Column(name = "local_name")
    private String companyLocalName;

    @Column(name = "eng_name")
    private String companyEngName;

    @Column(name = "email")
    private String companyEmail;

    @Column(name = "phone")
    private String companyPhone;

    @Column(name = "address")
    private String companyAddress;

    @Column(name = "vat_number")
    private String vatNumber;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "image")
    private String image;

}
