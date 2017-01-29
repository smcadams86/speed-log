package com.smcad.speedtest.services

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

import java.text.SimpleDateFormat

@Service
public class SpeedTestService {

    private static final Logger log = LoggerFactory.getLogger(SpeedTestService.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Value('${speed.script}')
    private String speedTestScript;

    @Scheduled(fixedRate = 3600000L)
    public void reportCurrentTime() {
        log.info("Executing speed test at {}", dateFormat.format(new Date()));

        new ProcessBuilder(speedTestScript).start();

    }
}

