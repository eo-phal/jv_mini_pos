package com.phall.demo.dto;

import lombok.Data;

@Data
public class ExchangeRateDTO {
    // @NotBlank(message = "Name is mandatory")
    // @Length(min = 3, max = 5, message = "Name be between 3 and 5 characters")
    private Double exchangeRate;
}
