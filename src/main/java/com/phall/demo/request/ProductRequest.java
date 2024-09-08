package com.phall.demo.request;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductRequest {
    @NotBlank(message = "Name is mandatorys")
    @Length(min = 3, max = 5, message = "Name be between 3 and 5 characters")
    private String title;
}
