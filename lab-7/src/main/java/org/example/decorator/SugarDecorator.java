package org.example.decorator;

import org.example.behavior.Beverage;

public class SugarDecorator extends BeverageDecorator {
    public SugarDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", with Sugar";
    }

    @Override
    public double getTotalPrice() {
        return beverage.getTotalPrice() + 0.2;
    }
}
