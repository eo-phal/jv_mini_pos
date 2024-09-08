package com.phall.demo.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ExchangeRateRequest {

    @NotBlank(message = "Exchange rate is blank")
    @NotNull(message = "Exchange is null")
    private Double exchangeRate;
}
