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

import com.phall.demo.entity.GeneralSetting;
import com.phall.demo.mapper.GeneralSettingMapper;
import com.phall.demo.request.GeneralSettingRequest;
import com.phall.demo.response.GeneralSettingResponse;
import com.phall.demo.service.GeneralSettingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("general-setting")
public class GeneralSettingController {

    @Autowired
    private GeneralSettingService generalSettingService;

    @Autowired
    private GeneralSettingMapper generalSettingMapper;
        
    @GetMapping
    public ResponseEntity<List<GeneralSettingResponse>> getAllEntity(){
        List<GeneralSettingResponse> response = generalSettingService.listAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<GeneralSettingResponse> saveData(@Valid @RequestBody GeneralSettingRequest dto){
        GeneralSetting generalSetting = generalSettingMapper.toEntity(dto);
        GeneralSetting saveData = generalSettingService.saveData(generalSetting);

        GeneralSettingResponse response = generalSettingMapper.toDTO(saveData);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<GeneralSettingResponse> getById(@PathVariable Long id){
        GeneralSetting getData = generalSettingService.getById(id);
        GeneralSettingResponse response = generalSettingMapper.toDTO(getData);
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<GeneralSettingResponse> update(@PathVariable Long id, @RequestBody GeneralSettingRequest dto){
        GeneralSetting generalSetting = generalSettingMapper.toEntity(dto);
        GeneralSetting update = generalSettingService.update(id, generalSetting);
        GeneralSettingResponse response = generalSettingMapper.toDTO(update);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        generalSettingService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
