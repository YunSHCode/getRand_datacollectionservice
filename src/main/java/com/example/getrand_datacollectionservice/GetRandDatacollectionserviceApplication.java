package com.example.getrand_datacollectionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GetRandDatacollectionserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetRandDatacollectionserviceApplication.class, args);
    }

}
