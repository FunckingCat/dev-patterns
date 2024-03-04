package org.example.model;

import org.example.behavior.Beverage;

public class Coffee implements Beverage {
    @Override
    public String getDescription() {
        return "Coffee";
    }

    @Override
    public double cost() {
        return 2.0;
    }
}
