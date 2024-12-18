package com.example.getrand_datacollectionservice.service;

import com.example.getrand_datacollectionservice.dto.ValuesDTO;
import com.example.getrand_datacollectionservice.dto.defaultTrendMonthsDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TrendServiceImpl implements TrendService {
    private final TrendAPIService apiService;
    private final ObjectMapper mapper;
    @Value("${serp.api-key}")
    private String apiKey;

    @Override
    public void yearTrend() {
        try {
            String jsonResponse = apiService.defaultTrend("google_trends", "develop", "today 12-m", apiKey);
            JsonNode rootNode = mapper.readTree(jsonResponse);
            JsonNode timelineData = rootNode.path("interest_over_time").get("timeline_data");
            List<defaultTrendMonthsDTO> defaultTrending = new ArrayList<>();
            System.out.println(timelineData);

            if (timelineData != null && timelineData.isArray()) { // timelineData가 배열인지 확인
                for (JsonNode node : timelineData) {
                    defaultTrendMonthsDTO dto = new defaultTrendMonthsDTO();
                    ValuesDTO valuesDTO = new ValuesDTO();

                    // JsonNode 그대로 활용하여 값 설정
                    if (node.has("query")) {
                        valuesDTO.setQuery(node.get("query").asText());
                    }
                    if (node.has("value")) {
                        valuesDTO.setValue(node.get("value").asText());
                    }
                    if (node.has("date")) {
                        dto.setDate(node.get("date").asText());
                    }

                    // dto.setValues(valuesDTO); // DTO 내 Values 설정
                    System.out.println(dto.getDate());
                    System.out.println(valuesDTO.getQuery());
                    System.out.println(valuesDTO.getValue());
                    defaultTrending.add(dto);
                }
            }
        } catch (JsonProcessingException e) { // readTree 예외 처리
            throw new RuntimeException(e);
        }
    }
}
