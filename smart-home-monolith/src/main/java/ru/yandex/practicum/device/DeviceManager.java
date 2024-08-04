package ru.yandex.practicum.device;

import java.util.HashMap;
import java.util.Map;

public class DeviceManager {
    private Map<String, Device> devices = new HashMap<>();

    public void addDevice(Device device) {
        devices.put(device.getId(), device);
        device.connect();
    }

    public void removeDevice(String deviceId) {
        Device device = devices.get(deviceId);
        if (device != null) {
            device.disconnect();
            devices.remove(deviceId);
        }
    }

    public Device getDevice(String deviceId) {
        return devices.get(deviceId);
    }

    public void displayConnectedDevices() {
        System.out.println("Подключенные устройства:");
        for (Device device : devices.values()) {
            System.out.println(device.getType() + " (ID: " + device.getId() + ")");
        }
    }
}