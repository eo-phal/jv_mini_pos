package com.phall.demo.response;

import lombok.Data;

@Data
public class CustomerResponse {
    private Integer id;
    private String customerLocalName;
    private String customerEngName;
    private String customerEmail;
    private String customerPhone;
    private String customerAddress;
}
