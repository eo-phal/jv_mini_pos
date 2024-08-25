package com.phall.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phall.demo.dto.GeneralSettingDTO;
import com.phall.demo.entity.GeneralSetting;
import com.phall.demo.mapper.GeneralSettingMapper;
import com.phall.demo.service.GeneralSettingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("general-setting")
public class GeneralSettingController {

    @Autowired
    private GeneralSettingService generalSettingService;
        
    @GetMapping
    public ResponseEntity<?> getAllEntity(){
        List<GeneralSetting> listAll = generalSettingService.listAll();
        return ResponseEntity.ok(listAll);
    }

    @PostMapping
    public ResponseEntity<?> saveData(@Valid @RequestBody GeneralSettingDTO dto){
        GeneralSetting generalSetting = GeneralSettingMapper.toGeneralSetting(dto);
        GeneralSetting saveData = generalSettingService.saveData(generalSetting);

        GeneralSettingDTO dto2 = GeneralSettingMapper.toDTO(saveData);
        return ResponseEntity.ok(dto2);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        GeneralSetting getData = generalSettingService.getById(id);
        GeneralSettingDTO dto = GeneralSettingMapper.toDTO(getData);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody GeneralSettingDTO dto){
        GeneralSetting generalSetting = GeneralSettingMapper.toGeneralSetting(dto);
        GeneralSetting update = generalSettingService.update(id, generalSetting);
        GeneralSettingDTO dataUpdate = GeneralSettingMapper.toDTO(update);
        return ResponseEntity.ok(dataUpdate);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        generalSettingService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
