package ru.yandex.practicum.lighting;

import ru.yandex.practicum.device.AbstractDevice;

public class LightingSystem extends AbstractDevice {
    private boolean isOn;

    @Override
    public String getType() {
        return "LightingSystem";
    }

    public void turnOn() {
        isOn = true;
        System.out.println("Освещение включено");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Освещение выключено");
    }

    public boolean isOn() {
        return isOn;
    }
}