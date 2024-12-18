package com.example.getrand_datacollectionservice.repository;

import com.example.getrand_datacollectionservice.dto.RelatedTopicsDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelatedTopicsRepository extends JpaRepository<RelatedTopicsDTO, Long> {
}