package org.example.decorator;

import org.example.behavior.Beverage;

public abstract class BeverageDecorator implements Beverage {
    protected Beverage beverage;

    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription();
    }

    @Override
    public final String getVolume() {
        return beverage.getVolume();
    }

    @Override
    public final void setVolume(double volume) {
        beverage.setVolume(volume);
    }

    @Override
    public double cost() {
        return beverage.cost();
    }
}
