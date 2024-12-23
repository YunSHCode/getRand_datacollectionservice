package com.example.getrand_datacollectionservice.service;

import com.example.getrand_datacollectionservice.dao.TrendDAO;
import com.example.getrand_datacollectionservice.dto.*;
import com.example.getrand_datacollectionservice.entity.DefaultPastOYEntity;
import com.example.getrand_datacollectionservice.entity.RealTimeTrendEntity;
import com.example.getrand_datacollectionservice.entity.RelatedQueriesEntity;
import com.example.getrand_datacollectionservice.entity.RelatedTopicsEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrendServiceImpl implements TrendService {
    private final TrendAPIService apiService;
    private final TrendDAO dao;
    private final ObjectMapper mapper;
    @Value("${serp.api-key}")
    private String apiKey;

    @Override
    public void pastOneYear() {
        try {
            String jsonResponse = apiService.defaultTrend("google_trends", "develop", "today 12-m", apiKey);
            JsonNode rootNode = mapper.readTree(jsonResponse);
            JsonNode timelineData = rootNode.path("interest_over_time").path("timeline_data");
            System.out.println(timelineData);

            List<DefaultPastOYEntity> defaultTrending = new ArrayList<>();

            if (timelineData != null && timelineData.isArray()) { // timelineData가 배열인지 확인
                for (JsonNode node : timelineData) {
                    // defaultTrendMonthsDTO 객체 생성
                    DefaultPastOYEntity dto = new DefaultPastOYEntity();
                    dto.setDate(node.get("date").asText());
                    JsonNode values = node.path("values").get(0);
                    if(values != null) {
                        dto.setValue(values.get("value").asText());
                    }
                    defaultTrending.add(dto);
                }
            }
            dao.insertDOY(defaultTrending);

        } catch (JsonProcessingException e) { // readTree 예외 처리
            throw new RuntimeException(e);
        }
    }

    @Override
    public void fetchRealTimeTrend() {
        try {
            String jsonResponse = apiService.getRealTimeTrand("KR", "google_trends_trending_now", apiKey);
            JsonNode rootNode = mapper.readTree(jsonResponse);
            JsonNode trendingSearchesNode = rootNode.path("trending_searches");
            List<RealTimeTrendEntity> trendingSearches = new ArrayList<>();
            if (trendingSearchesNode != null) {
                int limit = Math.min(trendingSearchesNode.size(), 10);
                int count = 0;
                for (JsonNode node : trendingSearchesNode) {
                    RealTimeTrendEntity entity = new RealTimeTrendEntity();
                    entity.setQuery(node.get("query").asText());
                    entity.setSearchVolume(node.get("search_volume").asInt());
                    entity.setIncreasePercentage(node.get("increase_percentage").asInt());
                    System.out.println(entity);
                    trendingSearches.add(entity);
                    count++;
                    if (count == limit) break;
                }
            }
            dao.insertRtt(trendingSearches);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void fetchRelatedQueries() {
        try {
            String jsonResponse = apiService.getRelatedQueries("KR", "google_trends","RELATED_QUERIES" , "develop",apiKey);
            JsonNode rootNode = mapper.readTree(jsonResponse);
            JsonNode topQueriesNode = rootNode.path("related_queries").path("top");
            List<RelatedQueriesEntity> topQueries = new ArrayList<>();
            // 'top' 노드가 비어있지 않다면 처리
            if (topQueriesNode != null && topQueriesNode.isArray()) {
                int limit = Math.min(topQueriesNode.size(), 10); // 최대 10개까지만 처리
                for (int i = 0; i < limit; i++) {
                    JsonNode node = topQueriesNode.get(i);
                    RelatedQueriesEntity entity = new RelatedQueriesEntity();

                    // 필드 값 매핑
                    entity.setQuery(node.get("query").asText());
                    entity.setValue(node.get("value").asText());
                    entity.setExtractedValue(node.get("extracted_value").asInt());

                    // 엔티티 출력 및 리스트 추가
                    System.out.println(entity);
                    topQueries.add(entity);
                }
            }
            dao.insertRq(topQueries);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void fetchRelatedTopics() {
        try {
            String jsonResponse = apiService.getRelatedTopics("KR", "google_trends","RELATED_TOPICS" , "develop",apiKey);
            JsonNode rootNode = mapper.readTree(jsonResponse);
            JsonNode topTopicsNode = rootNode.path("related_topics").path("top");
            List<RelatedTopicsEntity> topTopics = new ArrayList<>();
            // 'top' 노드가 비어있지 않다면 처리
            if (topTopicsNode != null && topTopicsNode.isArray()) {
                int limit = Math.min(topTopicsNode.size(), 10);
                for (int i = 0; i < limit; i++) {
                    JsonNode node = topTopicsNode.get(i);
                    RelatedTopicsEntity entity = new RelatedTopicsEntity();
                    JsonNode topicNode = node.get("topic");
                    if (topicNode != null) {
                        entity.setTitle(topicNode.get("title").asText());
                        entity.setType(topicNode.get("type").asText());
                    }

                    entity.setValue(node.get("value").asText());
                    entity.setExtractedValue(node.get("extracted_value").asInt());

                    System.out.println(entity);
                    topTopics.add(entity);
                }
            }
            dao.insertRt(topTopics);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void pastOneYearDeleteAll() {
        dao.deleteDOY();
    }

    @Override
    public void fetchRealTimeTrendDeleteAll() {
        dao.deleteRtt();
    }

    @Override
    public void fetchRelatedQueriesDeleteAll() {
        dao.deleteRq();
    }

    @Override
    public void fetchRelatedTopicsDeleteAll() {
        dao.deleteRt();
    }

    @Override
    public List<DefaultPastOYResponseDTO> pastOneYearFindAll() {
        List<DefaultPastOYEntity> poyList = dao.findDOY();
        List<DefaultPastOYResponseDTO> poyResponseList = new ArrayList<>();
        for (DefaultPastOYEntity poy : poyList) {
            DefaultPastOYResponseDTO poyResponse = new DefaultPastOYResponseDTO();
            poyResponse.setDate(poy.getDate());
            poyResponse.setValue(poy.getValue());
            poyResponseList.add(poyResponse);
        }
        return poyResponseList;
    }

    @Override
    public List<RealTimeTrendResponseDTO> realTimeTrendFindAll() {
        List<RealTimeTrendEntity> list = dao.findRtt();
        System.out.println(list);
        System.out.println(list.stream().map(RealTimeTrendEntity::getQuery).collect(Collectors.toList()));
        return list.stream()
                .map(entity -> new RealTimeTrendResponseDTO(
                        entity.getId(),
                        entity.getQuery(),
                        entity.getSearchVolume(),
                        entity.getIncreasePercentage(),
                        entity.getCreateDate(),
                        entity.getUpdateDate()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<RelatedTopicsResponseDTO> relatedTopicsFindAll() {
        List<RelatedTopicsEntity> list = dao.findRt();
        return list.stream()
                .map(entity -> new RelatedTopicsResponseDTO(
                        entity.getId(),
                        entity.getTitle(),
                        entity.getType(),
                        entity.getValue(),
                        entity.getExtractedValue(),
                        entity.getCreateDate(),
                        entity.getUpdateDate()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<RelatedQueriesResponseDTO> relatedQueriesFindAll() {
        List<RelatedQueriesEntity> list = dao.findRq();
        return list.stream()
                .map(entity -> new RelatedQueriesResponseDTO(
                        entity.getId(),
                        entity.getQuery(),
                        entity.getValue(),
                        entity.getExtractedValue(),
                        entity.getCreateDate(),
                        entity.getUpdateDate()
                ))
                .collect(Collectors.toList());
    }


}
