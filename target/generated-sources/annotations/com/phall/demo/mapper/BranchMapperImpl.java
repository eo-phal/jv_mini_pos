package com.phall.demo.mapper;

import com.phall.demo.entity.Branch;
import com.phall.demo.request.BranchRequest;
import com.phall.demo.response.BranchResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-08T21:24:38+0700",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class BranchMapperImpl implements BranchMapper {

    @Override
    public Branch toEntity(BranchRequest request) {
        if ( request == null ) {
            return null;
        }

        Branch branch = new Branch();

        branch.setName( request.getName() );

        return branch;
    }

    @Override
    public BranchResponse toDTO(Branch entity) {
        if ( entity == null ) {
            return null;
        }

        BranchResponse branchResponse = new BranchResponse();

        if ( entity.getId() != null ) {
            branchResponse.setId( entity.getId().intValue() );
        }
        branchResponse.setName( entity.getName() );

        return branchResponse;
    }
}
