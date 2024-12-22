package com.example.getrand_datacollectionservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "related_topics")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RelatedTopicsEntity extends PublicInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String type;
    private String value;
    private int extractedValue;
}