package com.phall.demo.request;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BranchRequest {
    @NotBlank(message = "Name is mandatory")
    @NotNull(message = "Name is not null")
    @Length(min = 3, message = "Name must be 3 digits")
    private String name;

}
