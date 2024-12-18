package com.example.getrand_datacollectionservice.repository;

import com.example.getrand_datacollectionservice.dto.RealTimeTrendDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealTimeTrendRepository extends JpaRepository<RealTimeTrendDTO, Long> {

}