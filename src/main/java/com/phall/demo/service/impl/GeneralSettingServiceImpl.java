package com.phall.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phall.demo.entity.GeneralSetting;
import com.phall.demo.exception.ResourceNotFoundException;
import com.phall.demo.repository.GeneralSettingRepository;
import com.phall.demo.service.GeneralSettingService;

@Service
public class GeneralSettingServiceImpl implements GeneralSettingService{

    @Autowired
    private GeneralSettingRepository generalSettingRepository;

    public List<GeneralSetting> listAll(){
        return generalSettingRepository.findAll();
    }

    @Override
    public GeneralSetting saveData(GeneralSetting generalSetting){
        return generalSettingRepository.save(generalSetting);
    }

    public GeneralSetting getById(Long id){
        return generalSettingRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("General setting", id));
    }

    @Override
    public GeneralSetting update(Long id, GeneralSetting update) {
        GeneralSetting dataUpdate = getById(id);
        dataUpdate.setSiteTitle(update.getSiteTitle());
        dataUpdate.setSitePhone(update.getSitePhone());
        dataUpdate.setSiteLogo(update.getSiteLogo());
        dataUpdate.setSiteAddress(update.getSiteAddress());
        return generalSettingRepository.save(dataUpdate);
    }

    @Override
    public void deleteById(Long id) {
        GeneralSetting byId = getById(id);
        generalSettingRepository.delete(byId);
    }
}
