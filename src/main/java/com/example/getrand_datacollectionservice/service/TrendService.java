package com.example.getrand_datacollectionservice.service;

public interface TrendService {
    void pastOneYear();
    void fetchRealTimeTrend();
    void fetchRelatedQueries();
    void fetchRelatedTopics();
    void pastOneYearDeleteAll();
    void fetchRealTimeTrendDeleteAll();
    void fetchRelatedQueriesDeleteAll();
    void fetchRelatedTopicsDeleteAll();
}
