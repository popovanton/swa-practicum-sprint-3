package ru.yandex.practicum.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.home.SmartHome;

@RestController
@RequestMapping("/api/smart-home")
@Api(value = "Smart Home Controller", description = "Operations pertaining to smart home management")
public class SmartHomeController {

    private final SmartHome smartHome;

    @Autowired
    public SmartHomeController(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @PostMapping("/temperature")
    @ApiOperation(value = "Set target temperature")
    public void setTargetTemperature(@RequestParam double temperature) {
        smartHome.setTargetTemperature(temperature);
    }

    @PostMapping("/lighting")
    @ApiOperation(value = "Control lighting")
    public void controlLighting(@RequestParam boolean turnOn) {
        smartHome.controlLighting(turnOn);
    }

    @PostMapping("/gate")
    @ApiOperation(value = "Control gate")
    public void controlGate(@RequestParam boolean open) {
        smartHome.controlGate(open);
    }

    @PostMapping("/surveillance")
    @ApiOperation(value = "Control surveillance")
    public void controlSurveillance(@RequestParam boolean activate) {
        smartHome.controlSurveillance(activate);
    }

    @GetMapping("/devices")
    @ApiOperation(value = "Get connected devices")
    public String getConnectedDevices() {
        smartHome.displayConnectedDevices();
        return "Connected devices displayed in console";
    }

    @GetMapping("/telemetry/{deviceType}")
    @ApiOperation(value = "Get device telemetry")
    public String getTelemetry(@PathVariable String deviceType) {
        smartHome.displayTelemetry(deviceType);
        return "Telemetry for " + deviceType + " displayed in console";
    }
}