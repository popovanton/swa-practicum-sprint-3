package ru.yandex.practicum.device;

import ru.yandex.practicum.telemetry.Telemetry;

public interface Device {
    String getId();
    String getType();
    void connect();
    void disconnect();
    boolean isConnected();
    Telemetry getTelemetry();
}