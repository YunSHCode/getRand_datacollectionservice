package com.example.getrand_datacollectionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelatedQueriesResponseDTO {
    private Long id;
    private String query;
    private String value;
    private int extractedValue;
    private Date createDate;
    private Date updateDate;
}
