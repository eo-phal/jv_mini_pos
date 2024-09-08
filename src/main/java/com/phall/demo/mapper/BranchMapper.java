package com.phall.demo.mapper;

import org.mapstruct.Mapper;

import com.phall.demo.entity.Branch;
import com.phall.demo.request.BranchRequest;
import com.phall.demo.response.BranchResponse;

@Mapper(componentModel = "spring")
public interface BranchMapper {

    Branch toEntity(BranchRequest request);
    BranchResponse toDTO(Branch entity);

} 
