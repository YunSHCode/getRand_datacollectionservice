package com.example.getrand_datacollectionservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/datacollectionservice")
public class GatewayController {
    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
