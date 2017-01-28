package com.smcad.speedtest

import com.smcad.speedtest.domain.SpeedTestResult
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value='/speed/v1')
class SpeedTestController {

    @RequestMapping(value = "log")
    public List<SpeedTestResult> getSpeedTestResults() {
        []
    }
}
