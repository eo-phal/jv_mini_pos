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
@Table(name = "general_settings")

public class GeneralSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "general_setting_id")
    private Long id;

    @Column(name = "site_title")
    private String siteTitle;

    @Column(name = "site_logo")
    private String siteLogo;

    @Column(name = "site_phone")
    private String sitePhone;

    @Column(name = "site_address")
    private String siteAddress;
}
