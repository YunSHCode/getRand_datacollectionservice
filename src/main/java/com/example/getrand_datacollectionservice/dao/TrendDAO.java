package com.example.getrand_datacollectionservice.dao;

import com.example.getrand_datacollectionservice.entity.DefaultPastOYEntity;
import com.example.getrand_datacollectionservice.entity.RealTimeTrendEntity;
import com.example.getrand_datacollectionservice.entity.RelatedQueriesEntity;
import com.example.getrand_datacollectionservice.entity.RelatedTopicsEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TrendDAO {
    void insertRtt(List<RealTimeTrendEntity> dto);
    void insertRq(List<RelatedQueriesEntity> dto);
    void insertRt(List<RelatedTopicsEntity> dto);
    void insertDOY(List<DefaultPastOYEntity> dto);
    void deleteRtt();
    void deleteRq();
    void deleteRt();
    void deleteDOY();
    List<DefaultPastOYEntity> findDOY();
    List<RealTimeTrendEntity> findRtt();
    List<RelatedTopicsEntity> findRt();
    List<RelatedQueriesEntity> findRq();
}