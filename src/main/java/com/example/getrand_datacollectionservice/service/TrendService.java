package com.example.getrand_datacollectionservice.service;

import com.example.getrand_datacollectionservice.dto.DefaultPastOYResponseDTO;

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
}
