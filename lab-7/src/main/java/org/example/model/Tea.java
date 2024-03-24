package org.example.model;

import org.example.behavior.Beverage;

import java.util.List;

public class Tea extends AbstractBevarage {
    public Tea(String type, List<String> recipe, List<String> ingredients, Float basePrice) {
        super(type, "Tea", recipe, ingredients, basePrice);
    }


    @Override
    public double getTotalPrice() {
        return getBasePrice() * getVolume();
    }
}
