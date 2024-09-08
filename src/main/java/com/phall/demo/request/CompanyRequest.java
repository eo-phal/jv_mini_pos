package com.phall.demo.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CompanyRequest {
    
    @NotBlank(message = "Local name is not blank")
    @NotNull(message = "Name is null")
    private String companyLocalName;

    @NotBlank(message = "English name is not blank")
    @NotNull(message = "English is null")
    private String companyEngName;

    @NotBlank(message = "Email name is blank")
    @NotNull(message = "Email is null")
    @Email(message = "Invalid email address")
    private String companyEmail;

    @NotBlank(message = "Phone is blank")
    @NotNull(message = "Phone is null")
    private String companyPhone;

    @NotBlank(message = "Address is blank")
    @NotNull(message = "Address is null")
    private String companyAddress;

    @NotBlank(message = "Vat number is blank")
    @NotNull(message = "Vat number is null")
    private String vatNumber;

    @NotBlank(message = "Image path is blank")
    private String imagePath;

    @NotBlank(message = "Image is null")
    private String image;
}
