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

import com.phall.demo.entity.Branch;
import com.phall.demo.mapper.BranchMapper;
import com.phall.demo.request.BranchRequest;
import com.phall.demo.response.BranchResponse;
import com.phall.demo.service.BranchService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("branch")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @Autowired
    private BranchMapper branchMapper;
        
    @GetMapping
    public ResponseEntity<List<BranchResponse>> getAllEntity(){
        List<BranchResponse> response = branchService.listAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<BranchResponse> saveData(@Valid @RequestBody BranchRequest dto){
        Branch branch = branchMapper.toEntity(dto);
        Branch saveData = branchService.saveData(branch);

        BranchResponse response = branchMapper.toDTO(saveData);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<BranchResponse> getById(@PathVariable Long id){
        Branch getData = branchService.getById(id);
        BranchResponse response = branchMapper.toDTO(getData);
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<BranchResponse> update(@PathVariable Long id, @Valid @RequestBody BranchRequest dto){
        Branch branch = branchMapper.toEntity(dto);
        Branch update = branchService.update(id, branch);
        BranchResponse response = branchMapper.toDTO(update);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        branchService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
