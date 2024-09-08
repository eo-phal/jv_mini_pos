package com.phall.demo.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerRequest {

    @NotBlank(message = "local name is not blank")
    @NotNull(message = "Name os null")
    private String customerLocalName;

    @NotBlank(message = "English name is not blank")
    @NotNull(message = "English name is null")
    private String customerEngName;

    @NotBlank(message = "Email is not blank")
    @NotNull(message = "Email is null")
    @Email(message = "Invalid email address")
    private String customerEmail;

    @NotBlank(message = "Phone is not blank")
    @NotNull(message = "Phone is null")
    private String customerPhone;

    @NotBlank(message = "Address is not blank")
    @NotNull(message = "Address is null")
    private String customerAddress;
}
