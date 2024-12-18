package com.example.getrand_datacollectionservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "googleTrend", url = "https://serpapi.com/search.json")
public interface TrendAPIService {
    @GetMapping("")
    String defaultTrend(@RequestParam("engine") String engine,
                        @RequestParam("q") String q,
                        @RequestParam("date") String date,
                        @RequestParam("api_key") String apiKey);
}
