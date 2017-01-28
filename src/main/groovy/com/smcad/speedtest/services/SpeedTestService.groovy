package com.smcad.speedtest.services

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

import java.text.SimpleDateFormat

@Service
public class SpeedTestService {

    private static final Logger log = LoggerFactory.getLogger(SpeedTestService.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 60000L)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }
}

