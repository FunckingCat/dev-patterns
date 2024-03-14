package org.example.model;

import org.example.behavior.Beverage;

public class Fresh extends AbstractBevarage {
    public Fresh(String type) {
        super(type, "Fresh");
    }

    @Override
    public double cost() {
        return 2.0;
    }
}
