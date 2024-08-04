package ru.yandex.practicum.monitoring;

public class TemperatureMonitor {
    private double currentTemperature;

    public void updateTemperature(double temperature) {
        currentTemperature = temperature;
        System.out.println("Текущая температура: " + temperature + " градусов");
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }
}