package ru.yandex.practicum.heating;

import ru.yandex.practicum.device.AbstractDevice;

public class HeatingSystem extends AbstractDevice {
    private boolean isOn;
    private double targetTemperature;

    @Override
    public String getType() {
        return "HeatingSystem";
    }

    public void turnOn() {
        isOn = true;
        System.out.println("Отопление включено");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Отопление выключено");
    }

    public void setTargetTemperature(double temperature) {
        targetTemperature = temperature;
        System.out.println("Целевая температура установлена на " + temperature + " градусов");
    }

    public double getTargetTemperature() {
        return targetTemperature;
    }

    public boolean isOn() {
        return isOn;
    }
}
