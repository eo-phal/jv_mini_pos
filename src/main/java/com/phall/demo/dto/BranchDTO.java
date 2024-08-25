package com.phall.demo.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BranchDTO {
    @NotBlank(message = "Name is mandatory")
    @Length(min = 3, max = 5, message = "Name be between 3 and 5 characters")
    private String name;
    // private Long id;
}
