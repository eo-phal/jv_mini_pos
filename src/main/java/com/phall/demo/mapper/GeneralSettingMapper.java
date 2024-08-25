package com.phall.demo.mapper;

import com.phall.demo.dto.GeneralSettingDTO;
import com.phall.demo.entity.GeneralSetting;

public class GeneralSettingMapper {
    public static GeneralSetting toGeneralSetting(GeneralSettingDTO dto){
        GeneralSetting generalSetting = new GeneralSetting();
        generalSetting.setSiteTitle(dto.getSiteTitle());
        generalSetting.setSitePhone(dto.getSitePhone());
        generalSetting.setSiteLogo(dto.getSiteLogo());
        generalSetting.setSiteAddress(dto.getSiteAddress());
        return generalSetting;
    }

    public static GeneralSettingDTO toDTO(GeneralSetting entity){
        GeneralSettingDTO dto = new GeneralSettingDTO();
        dto.setSiteTitle(entity.getSiteTitle());
        dto.setSitePhone(entity.getSitePhone());
        dto.setSiteLogo(entity.getSiteLogo());
        dto.setSiteAddress(entity.getSiteAddress());
        return dto;
    }
}
