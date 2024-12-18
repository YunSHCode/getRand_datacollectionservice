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
}
