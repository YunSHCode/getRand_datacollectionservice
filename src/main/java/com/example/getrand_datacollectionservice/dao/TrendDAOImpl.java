package com.example.getrand_datacollectionservice.dao;

import com.example.getrand_datacollectionservice.dto.DefaultPastOYDTO;
import com.example.getrand_datacollectionservice.dto.RealTimeTrendDTO;
import com.example.getrand_datacollectionservice.dto.RelatedQueriesDTO;
import com.example.getrand_datacollectionservice.dto.RelatedTopicsDTO;
import com.example.getrand_datacollectionservice.repository.DefaultPastOYRepository;
import com.example.getrand_datacollectionservice.repository.RealTimeTrendRepository;
import com.example.getrand_datacollectionservice.repository.RelatedQueriesRepository;
import com.example.getrand_datacollectionservice.repository.RelatedTopicsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TrendDAOImpl implements TrendDAO {
    private final RealTimeTrendRepository rtRepository;
    private final RelatedQueriesRepository relatedQueriesRepository;
    private final RelatedTopicsRepository relatedTopicsRepository;
    private final DefaultPastOYRepository defaultPastOYRepository;

    @Override
    public void insertRtt(List<RealTimeTrendDTO> dtos) {
        rtRepository.saveAll(dtos);
    }

    @Override
    public void insertRq(List<RelatedQueriesDTO> dtos) {
        relatedQueriesRepository.saveAll(dtos);
    }

    @Override
    public void insertRt(List<RelatedTopicsDTO> dtos) {
        relatedTopicsRepository.saveAll(dtos);
    }

    @Override
    public void insertDOY(List<DefaultPastOYDTO> dtos) {
        defaultPastOYRepository.saveAll(dtos);
    }
}