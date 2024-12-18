package com.example.getrand_datacollectionservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Scheduler {
    private final TrendService trendService;

    @Scheduled(cron = "0 0 * * * ?")
    public void fetchRealTimeTrends() {
        trendService.fetchRealTimeTrend();
    }
}
