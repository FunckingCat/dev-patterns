package org.example.decorator;

import org.example.behavior.Beverage;

import java.util.List;

public class MilkDecorator extends BeverageDecorator {
    public MilkDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", with Milk";
    }

    @Override
    public double getTotalPrice() {
        return beverage.getTotalPrice() + 0.5;
    }
}
