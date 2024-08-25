package com.phall.demo.service;

import java.util.List;

import com.phall.demo.entity.Branch;

public interface BranchService {

    List<Branch> listAll();

    Branch saveData(Branch branch);

    Branch getById(Long id);

    Branch update(Long id, Branch update);

    void deleteById(Long id);
}
