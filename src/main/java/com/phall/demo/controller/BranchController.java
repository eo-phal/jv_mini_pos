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

import com.phall.demo.dto.BranchDTO;
import com.phall.demo.entity.Branch;
import com.phall.demo.mapper.BranchMapper;
import com.phall.demo.service.BranchService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("branch")
public class BranchController {

    @Autowired
    private BranchService branchService;
        
    @GetMapping
    public ResponseEntity<?> getAllEntity(){
        List<Branch> listAll = branchService.listAll();
        return ResponseEntity.ok(listAll);
    }

    @PostMapping
    public ResponseEntity<?> saveData(@Valid @RequestBody BranchDTO dto){
        Branch branch = BranchMapper.toBranch(dto);
        Branch saveData = branchService.saveData(branch);

        BranchDTO dto2 = BranchMapper.toDTO(saveData);
        return ResponseEntity.ok(dto2);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Branch getData = branchService.getById(id);
        BranchDTO dto = BranchMapper.toDTO(getData);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody BranchDTO dto){
        Branch branch = BranchMapper.toBranch(dto);
        Branch update = branchService.update(id, branch);
        BranchDTO dataUpdate = BranchMapper.toDTO(update);
        return ResponseEntity.ok(dataUpdate);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        branchService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
