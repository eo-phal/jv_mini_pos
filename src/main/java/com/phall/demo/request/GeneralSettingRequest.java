package com.phall.demo.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class GeneralSettingRequest {
    
    @NotBlank(message = "Site title is blank")
    private String siteTitle;

    @NotBlank(message = "Site Logo is blank")
    private String siteLogo;

    @NotBlank(message = "Site phone is blank")
    private String sitePhone;

    @NotBlank(message = "Site address is blank")
    private String siteAddress;
}
