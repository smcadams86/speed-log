package com.smcad.speedtest

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
public class SpeedLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.smcad.speedtest.SpeedLogApplication.class, args);
    }
}

