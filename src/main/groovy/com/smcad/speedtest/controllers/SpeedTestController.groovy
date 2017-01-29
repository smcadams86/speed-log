package com.smcad.speedtest.controllers

import com.smcad.speedtest.domain.SpeedTestResult
import com.smcad.speedtest.domain.SpeedTestResultLog
import groovy.json.JsonSlurper
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = '/speed/v1')
class SpeedTestController {

    @Value('${speed.log}')
    private String logFile;

    @RequestMapping(value = "log")
    public SpeedTestResultLog getSpeedTestResults() {
        new SpeedTestResultLog(
                log: new JsonSlurper().parseText(
                        new File(logFile).text
                ).log.collect { new SpeedTestResult(it) }
        )
    }
}
