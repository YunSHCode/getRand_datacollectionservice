package com.example.getrand_datacollectionservice.controller;

import com.example.getrand_datacollectionservice.service.TrendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/google")
@RequiredArgsConstructor
public class TrendAPIController {
    private final TrendService service;
    @GetMapping("/defaultPastOY")
    public String defaultTrendYear() {
        service.pastOneYear();
        return "ok";
    }

    @GetMapping("/defaultPastOY/update")
    public String UpdateDefaultTrendYear() {
        service.pastOneYearDeleteAll();
        service.pastOneYear();
        return "ok";
    }

    @GetMapping("/realtime")
    public String realtime() {
        service.fetchRealTimeTrend();
        return "ok";
    }

    @GetMapping("/realtime/update")
    public String UpdateRealtimeTrend() {
        service.fetchRealTimeTrendDeleteAll();
        service.fetchRealTimeTrend();
        return "ok";
    }

    @GetMapping("/relatedQueries")
    public String relatedQueries() {
        service.fetchRelatedQueries();
        return "ok";
    }

    @GetMapping("/relatedQueries/update")
    public String UpdateRelatedQueries() {
        service.fetchRelatedQueriesDeleteAll();
        service.fetchRelatedQueries();
        return "ok";
    }

    @GetMapping("/relatedTopics")
    public String relatedTopics() {
        service.fetchRelatedTopics();
        return "ok";
    }

    @GetMapping("/relatedTopics/update")
    public String UpdateRelatedTopics() {
        service.fetchRelatedTopicsDeleteAll();
        service.fetchRelatedTopics();
        return "ok";
    }


}
