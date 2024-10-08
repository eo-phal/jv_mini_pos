package com.phall.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phall.demo.entity.Branch;
import com.phall.demo.exception.ResourceNotFoundException;
import com.phall.demo.mapper.BranchMapper;
import com.phall.demo.repository.BranchRepository;
import com.phall.demo.response.BranchResponse;
import com.phall.demo.service.BranchService;

@Service
public class BranchServiceImpl implements BranchService{

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private BranchMapper branchMapper;

    public List<BranchResponse> listAll(){
        return branchRepository.findAll().stream().map(branchMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Branch saveData(Branch branch){
        return branchRepository.save(branch);
    }

    public Branch getById(Long id){
        return branchRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Branch", id));
    }

    @Override
    public Branch update(Long id, Branch update) {
        Branch dataUpdate = getById(id);
        dataUpdate.setName(update.getName());
        return branchRepository.save(dataUpdate);
    }

    @Override
    public void deleteById(Long id) {
        Branch byId = getById(id);
        branchRepository.delete(byId);
    }
}
