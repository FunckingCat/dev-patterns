package org.example.model;

import org.example.behavior.Beverage;

import java.util.List;

public class Fresh extends AbstractBevarage {
    public Fresh(String type, List<String> recipe, List<String> ingredients, Float basePrice) {
        super(type, "Fresh", recipe, ingredients, basePrice);
    }


    @Override
    public double getTotalPrice() {
        return getBasePrice() * getVolume();
    }
}
