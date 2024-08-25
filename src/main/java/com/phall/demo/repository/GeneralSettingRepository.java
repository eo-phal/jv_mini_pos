package com.phall.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phall.demo.entity.GeneralSetting;

@Repository
public interface GeneralSettingRepository extends JpaRepository<GeneralSetting, Long> {

}
