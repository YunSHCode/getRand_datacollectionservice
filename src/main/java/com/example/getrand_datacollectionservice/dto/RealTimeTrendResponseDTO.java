package com.example.getrand_datacollectionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RealTimeTrendResponseDTO {
    private Long id;
    private String query;
    private int searchVolume;
    private int increasePercentage;
    private Date createDate;
    private Date updateDate;
}