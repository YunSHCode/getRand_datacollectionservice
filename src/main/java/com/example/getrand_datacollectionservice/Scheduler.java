package com.example.getrand_datacollectionservice;

import com.example.getrand_datacollectionservice.service.TrendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class Scheduler {
    private final TrendService trendService;

    @Value("${schedule.use}")
    private boolean useSchedule;

    @Scheduled(cron = "${schedule.cron}")
    public void fetchRealTimeTrends() {
        trendService.fetchRealTimeTrend();
    }
}
