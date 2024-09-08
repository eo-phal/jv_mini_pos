package com.phall.demo.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SupplierRequest {

    @NotBlank(message = "Supplier local name is blank")
    private String supplierLocalName;

    @NotBlank(message = "Supplier english name is blank")
    private String supplierEngName;

    @NotBlank(message = "Supplier email is blank")
    private String supplierEmail;

    @NotBlank(message = "Supplier local phone is blank")
    private String supplierPhone;

    @NotBlank(message = "Supplier address is blank")
    private String supplierAddress;

    @NotBlank(message = "Supplier vat number is blank")
    private String supplierVatNumber;

}
