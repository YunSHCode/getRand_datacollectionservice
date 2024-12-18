package com.example.getrand_datacollectionservice.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "related_queries")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RelatedQueriesDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String query;
    private String value;
    private int extractedValue;
}