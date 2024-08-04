package ru.yandex.practicum.home;

import org.springframework.stereotype.Service;
import ru.yandex.practicum.device.Device;
import ru.yandex.practicum.device.DeviceManager;
import ru.yandex.practicum.heating.HeatingSystem;
import ru.yandex.practicum.lighting.LightingSystem;
import ru.yandex.practicum.gate.GateSystem;
import ru.yandex.practicum.surveillance.SurveillanceSystem;

import java.util.HashMap;
import java.util.Map;

@Service
public class SmartHome {
    private DeviceManager deviceManager;
    private Map<String, Runnable> scenarios;

    public SmartHome() {
        deviceManager = new DeviceManager();
        scenarios = new HashMap<>();
        initializeDevices();
    }

    private void initializeDevices() {
        deviceManager.addDevice(new HeatingSystem());
        deviceManager.addDevice(new LightingSystem());
        deviceManager.addDevice(new GateSystem());
        deviceManager.addDevice(new SurveillanceSystem());
    }

    public void addDevice(Device device) {
        deviceManager.addDevice(device);
    }

    public void removeDevice(String deviceType) {
        deviceManager.removeDevice(deviceType);
    }

    public void displayConnectedDevices() {
        deviceManager.displayConnectedDevices();
    }

    public void addScenario(String name, Runnable scenario) {
        scenarios.put(name, scenario);
        System.out.println("Добавлен новый сценарий: " + name);
    }

    public void runScenario(String name) {
        Runnable scenario = scenarios.get(name);
        if (scenario != null) {
            scenario.run();
            System.out.println("Выполнен сценарий: " + name);
        } else {
            System.out.println("Сценарий не найден: " + name);
        }
    }

    public void setTargetTemperature(double temperature) {
        Device heatingSystem = deviceManager.getDevice("HeatingSystem");
        if (heatingSystem instanceof HeatingSystem) {
            ((HeatingSystem) heatingSystem).setTargetTemperature(temperature);
        }
    }

    public void controlLighting(boolean turnOn) {
        Device lightingSystem = deviceManager.getDevice("LightingSystem");
        if (lightingSystem instanceof LightingSystem) {
            if (turnOn) {
                ((LightingSystem) lightingSystem).turnOn();
            } else {
                ((LightingSystem) lightingSystem).turnOff();
            }
        }
    }

    public void controlGate(boolean open) {
        Device gateSystem = deviceManager.getDevice("GateSystem");
        if (gateSystem instanceof GateSystem) {
            if (open) {
                ((GateSystem) gateSystem).open();
            } else {
                ((GateSystem) gateSystem).close();
            }
        }
    }

    public void controlSurveillance(boolean activate) {
        Device surveillanceSystem = deviceManager.getDevice("SurveillanceSystem");
        if (surveillanceSystem instanceof SurveillanceSystem) {
            if (activate) {
                ((SurveillanceSystem) surveillanceSystem).activate();
            } else {
                ((SurveillanceSystem) surveillanceSystem).deactivate();
            }
        }
    }

    public void displayTelemetry(String deviceType) {
        Device device = deviceManager.getDevice(deviceType);
        if (device != null) {
            System.out.println(device.getTelemetry().getData());
        } else {
            System.out.println("Устройство не найдено: " + deviceType);
        }
    }
}