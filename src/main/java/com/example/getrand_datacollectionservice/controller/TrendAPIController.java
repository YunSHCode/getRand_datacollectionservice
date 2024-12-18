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

    @GetMapping("/defaultTrendYear")
    public String defaultTrendYear() {
        service.yearTrend();

        return "ok";
    }

    @GetMapping("/realtime")
    public String realtime() {
        service.fetchRealTimeTrend();
        return "ok";
    }

    @GetMapping("/relatedQueries")
    public String relatedQueries() {
        service.fetchRelatedQueries();
        return "ok";
    }

    @GetMapping("/relatedTopics")
    public String relatedTopics() {
        service.fetchRelatedTopics();
        return "ok";
    }
}
