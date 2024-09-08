package com.phall.demo.mapper;

import org.mapstruct.Mapper;

import com.phall.demo.entity.GeneralSetting;
import com.phall.demo.request.GeneralSettingRequest;
import com.phall.demo.response.GeneralSettingResponse;

@Mapper(componentModel = "spring")
public interface GeneralSettingMapper {

    GeneralSetting toEntity(GeneralSettingRequest request);
    GeneralSettingResponse toDTO(GeneralSetting entity);

}
