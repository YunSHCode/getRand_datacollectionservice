package com.example.getrand_datacollectionservice.controller;

import com.example.getrand_datacollectionservice.dto.DefaultPastOYResponseDTO;
import com.example.getrand_datacollectionservice.service.TrendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/datacollectionservice")
@RequiredArgsConstructor
public class GatewayController {
    private final TrendService service;

    @GetMapping("/defaultPastOY/findall")
    @ResponseBody
    public List<DefaultPastOYResponseDTO> findDefaultTrendYear() {
        return service.pastOneYearFindAll();
    }

    @GetMapping("/defaultPastOY/update")
    @ResponseBody
    public List<DefaultPastOYResponseDTO> UpdateDefaultTrendYear() {
        service.pastOneYearDeleteAll();
        service.pastOneYear();
        return service.pastOneYearFindAll();
    }
}
