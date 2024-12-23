package com.example.getrand_datacollectionservice.service;

import com.example.getrand_datacollectionservice.dto.DefaultPastOYResponseDTO;
import com.example.getrand_datacollectionservice.dto.RealTimeTrendResponseDTO;
import com.example.getrand_datacollectionservice.dto.RelatedQueriesResponseDTO;
import com.example.getrand_datacollectionservice.dto.RelatedTopicsResponseDTO;
import com.example.getrand_datacollectionservice.entity.RealTimeTrendEntity;
import com.example.getrand_datacollectionservice.entity.RelatedQueriesEntity;
import com.example.getrand_datacollectionservice.entity.RelatedTopicsEntity;

import java.util.List;

public interface TrendService {
    void pastOneYear();
    void fetchRealTimeTrend();
    void fetchRelatedQueries();
    void fetchRelatedTopics();
    void pastOneYearDeleteAll();
    void fetchRealTimeTrendDeleteAll();
    void fetchRelatedQueriesDeleteAll();
    void fetchRelatedTopicsDeleteAll();
    List<DefaultPastOYResponseDTO> pastOneYearFindAll();
    List<RealTimeTrendResponseDTO> realTimeTrendFindAll();
    List<RelatedTopicsResponseDTO> relatedTopicsFindAll();
    List<RelatedQueriesResponseDTO> relatedQueriesFindAll();
}
