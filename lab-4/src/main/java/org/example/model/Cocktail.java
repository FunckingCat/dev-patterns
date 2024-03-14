package org.example.model;

import org.example.behavior.Beverage;

public class Cocktail extends AbstractBevarage {
    public Cocktail(String type) {
        super(type, "Cocktail");
    }

    @Override
    public double cost() {
        return 2.0;
    }
}
