package com.phall.demo.mapper;

import com.phall.demo.entity.GeneralSetting;
import com.phall.demo.request.GeneralSettingRequest;
import com.phall.demo.response.GeneralSettingResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-08T21:49:20+0700",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class GeneralSettingMapperImpl implements GeneralSettingMapper {

    @Override
    public GeneralSetting toEntity(GeneralSettingRequest request) {
        if ( request == null ) {
            return null;
        }

        GeneralSetting generalSetting = new GeneralSetting();

        generalSetting.setSiteAddress( request.getSiteAddress() );
        generalSetting.setSiteLogo( request.getSiteLogo() );
        generalSetting.setSitePhone( request.getSitePhone() );
        generalSetting.setSiteTitle( request.getSiteTitle() );

        return generalSetting;
    }

    @Override
    public GeneralSettingResponse toDTO(GeneralSetting entity) {
        if ( entity == null ) {
            return null;
        }

        GeneralSettingResponse generalSettingResponse = new GeneralSettingResponse();

        if ( entity.getId() != null ) {
            generalSettingResponse.setId( entity.getId().intValue() );
        }
        generalSettingResponse.setSiteAddress( entity.getSiteAddress() );
        generalSettingResponse.setSiteLogo( entity.getSiteLogo() );
        generalSettingResponse.setSitePhone( entity.getSitePhone() );
        generalSettingResponse.setSiteTitle( entity.getSiteTitle() );

        return generalSettingResponse;
    }
}
