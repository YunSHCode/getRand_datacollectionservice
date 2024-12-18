package com.example.getrand_datacollectionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class defaultTrendMonthsDTO {
    private String date;
    List<ValuesDTO> values = new ArrayList<>();
}

