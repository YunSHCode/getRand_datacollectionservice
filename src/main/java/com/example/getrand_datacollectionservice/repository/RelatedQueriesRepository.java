package com.example.getrand_datacollectionservice.repository;

import com.example.getrand_datacollectionservice.dto.RelatedQueriesDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelatedQueriesRepository extends JpaRepository<RelatedQueriesDTO, Long> {
}