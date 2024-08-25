package com.phall.demo.mapper;

import com.phall.demo.dto.BranchDTO;
import com.phall.demo.entity.Branch;

public class BranchMapper {
    public static Branch toBranch(BranchDTO dto){
        Branch branch = new Branch();
        branch.setName(dto.getName());
        return branch;
    }

    public static BranchDTO toDTO(Branch entity){
        BranchDTO dto = new BranchDTO();
        dto.setName(entity.getName());
        // dto.setId(entity.getId());
        return dto;
    }
}
