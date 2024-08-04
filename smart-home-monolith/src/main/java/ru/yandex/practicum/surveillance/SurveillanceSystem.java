package ru.yandex.practicum.surveillance;

import ru.yandex.practicum.device.AbstractDevice;

public class SurveillanceSystem extends AbstractDevice {
    private boolean isActive;

    @Override
    public String getType() {
        return "SurveillanceSystem";
    }

    public void activate() {
        isActive = true;
        System.out.println("Система наблюдения активирована");
    }

    public void deactivate() {
        isActive = false;
        System.out.println("Система наблюдения деактивирована");
    }

    public boolean isActive() {
        return isActive;
    }

    public void streamVideo() {
        if (isActive) {
            System.out.println("Трансляция видео...");
        } else {
            System.out.println("Система наблюдения не активна");
        }
    }
}