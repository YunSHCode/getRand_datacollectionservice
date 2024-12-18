package com.example.getrand_datacollectionservice.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "trends")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RealTimeTrendDTO extends PublicInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String query;
    private int searchVolume;
    private int increasePercentage;
}