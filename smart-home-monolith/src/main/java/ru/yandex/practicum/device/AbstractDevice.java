package ru.yandex.practicum.device;

import ru.yandex.practicum.telemetry.Telemetry;

import java.util.UUID;

public abstract class AbstractDevice implements Device {
    protected String id;
    protected boolean connected;

    public AbstractDevice() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void connect() {
        connected = true;
        System.out.println(getType() + " с ID " + id + " подключено");
    }

    @Override
    public void disconnect() {
        connected = false;
        System.out.println(getType() + " с ID " + id + " отключено");
    }

    @Override
    public boolean isConnected() {
        return connected;
    }

    @Override
    public Telemetry getTelemetry() {
        return () -> "Базовая телеметрия для " + getType() + " (ID: " + getId() + ")";
    }
}
