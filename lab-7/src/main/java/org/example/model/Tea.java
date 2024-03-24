package org.example.model;

import org.example.behavior.Beverage;

public class Tea extends AbstractBevarage {
    public Tea(String type) {
        super(type, "Tea");
    }

    @Override
    public double cost() {
        return 1.0;
    }
}
