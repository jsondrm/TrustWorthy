package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.dao","com.example.service"})
public class TwprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwprojectApplication.class, args);
    }
}
