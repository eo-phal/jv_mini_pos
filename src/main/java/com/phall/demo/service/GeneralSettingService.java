package com.phall.demo.service;

import java.util.List;

import com.phall.demo.entity.GeneralSetting;

public interface GeneralSettingService {

    List<GeneralSetting> listAll();

    GeneralSetting saveData(GeneralSetting branch);

    GeneralSetting getById(Long id);

    GeneralSetting update(Long id, GeneralSetting update);

    void deleteById(Long id);
}
