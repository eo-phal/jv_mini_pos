package com.phall.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.phall.demo.entity.ExchangeRate;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long>{

}
