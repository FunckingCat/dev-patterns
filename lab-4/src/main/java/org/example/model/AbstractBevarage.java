package org.example.model;

import org.example.behavior.Beverage;

public abstract class AbstractBevarage implements Beverage {

    private final String type;

    private final String name;

    private double volume = 0.0;

    public AbstractBevarage(String type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public String getVolume() {
        return "Volume: %s".formatted(volume);
    };

    public void setVolume(double volume){
        this.volume = volume;
    };

    public String getDescription() {
        return "%s %s".formatted(type, name);
    }

}
