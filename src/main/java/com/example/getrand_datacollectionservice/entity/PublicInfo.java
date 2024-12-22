package com.example.getrand_datacollectionservice.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@MappedSuperclass
public class PublicInfo {
    @CreationTimestamp
    private Date createDate;
    // Update 쿼리가 실행될 때 현재 날짜와 시간의 값을 저장해 마지막 수정시간을 자동으로 저장
    @UpdateTimestamp
    private Date updateDate;
}
