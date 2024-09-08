package com.phall.demo.service;

import java.util.List;

import com.phall.demo.entity.Branch;
import com.phall.demo.response.BranchResponse;

public interface BranchService {

    List<BranchResponse> listAll();

    Branch saveData(Branch branch);

    Branch getById(Long id);

    Branch update(Long id, Branch update);

    void deleteById(Long id);
}
