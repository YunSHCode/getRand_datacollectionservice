package com.example.getrand_datacollectionservice.controller;

import com.example.getrand_datacollectionservice.dto.DefaultPastOYResponseDTO;
import com.example.getrand_datacollectionservice.service.TrendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
