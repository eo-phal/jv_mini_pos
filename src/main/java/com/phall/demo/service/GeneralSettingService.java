package com.phall.demo.service;

import java.util.List;

import com.phall.demo.entity.GeneralSetting;
import com.phall.demo.response.GeneralSettingResponse;

public interface GeneralSettingService {

    List<GeneralSettingResponse> listAll();

    GeneralSetting saveData(GeneralSetting branch);

    GeneralSetting getById(Long id);

    GeneralSetting update(Long id, GeneralSetting update);

    void deleteById(Long id);
}
