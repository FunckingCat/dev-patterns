package org.example.model;

import org.example.behavior.Beverage;

public class Tea implements Beverage {
    @Override
    public String getDescription() {
        return "Tea";
    }

    @Override
    public double cost() {
        return 1.0;
    }
}
