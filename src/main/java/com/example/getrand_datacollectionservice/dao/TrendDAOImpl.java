package com.example.getrand_datacollectionservice.dao;

import com.example.getrand_datacollectionservice.entity.DefaultPastOYEntity;
import com.example.getrand_datacollectionservice.entity.RealTimeTrendEntity;
import com.example.getrand_datacollectionservice.entity.RelatedQueriesEntity;
import com.example.getrand_datacollectionservice.entity.RelatedTopicsEntity;
import com.example.getrand_datacollectionservice.repository.DefaultPastOYRepository;
import com.example.getrand_datacollectionservice.repository.RealTimeTrendRepository;
import com.example.getrand_datacollectionservice.repository.RelatedQueriesRepository;
import com.example.getrand_datacollectionservice.repository.RelatedTopicsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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
    public void insertRtt(List<RealTimeTrendEntity> dtos) {
        rtRepository.saveAll(dtos);
    }

    @Override
    public void insertRq(List<RelatedQueriesEntity> dtos) {
        relatedQueriesRepository.saveAll(dtos);
    }

    @Override
    public void insertRt(List<RelatedTopicsEntity> dtos) {
        relatedTopicsRepository.saveAll(dtos);
    }

    @Override
    public void insertDOY(List<DefaultPastOYEntity> dtos) {
        defaultPastOYRepository.saveAll(dtos);
    }

    @Override
    public void deleteRtt() {
        rtRepository.deleteAll();
    }

    @Override
    public void deleteRq() {
        relatedQueriesRepository.deleteAll();
    }

    @Override
    public void deleteRt() {
        relatedTopicsRepository.deleteAll();
    }

    @Override
    @Transactional
    public void deleteDOY() {
        defaultPastOYRepository.deleteAll();
        defaultPastOYRepository.resetAutoIncrement();
    }

    @Override
    public List<DefaultPastOYEntity> findDOY() {
        return defaultPastOYRepository.findAll();
    }

    @Override
    public List<RealTimeTrendEntity> findRtt() {
        return rtRepository.findAll();
    }

    @Override
    public List<RelatedTopicsEntity> findRt() {
        return relatedTopicsRepository.findAll();
    }

    @Override
    public List<RelatedQueriesEntity> findRq() {
        return relatedQueriesRepository.findAll();
    }
}