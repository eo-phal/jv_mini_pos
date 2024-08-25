package com.phall.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phall.demo.entity.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {

}
