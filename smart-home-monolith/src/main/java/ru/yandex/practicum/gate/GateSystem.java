package ru.yandex.practicum.gate;

import ru.yandex.practicum.device.AbstractDevice;

public class GateSystem extends AbstractDevice {
    private boolean isOpen;

    @Override
    public String getType() {
        return "GateSystem";
    }

    public void open() {
        isOpen = true;
        System.out.println("Ворота открыты");
    }

    public void close() {
        isOpen = false;
        System.out.println("Ворота закрыты");
    }

    public boolean isOpen() {
        return isOpen;
    }
}