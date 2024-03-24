package org.example.model;

import java.util.List;

public class Cocktail extends AbstractBevarage {
    public Cocktail(String type, List<String> recipe, List<String> ingredients, Float basePrice) {
        super(type, "Cocktail", recipe, ingredients, basePrice);
    }

    @Override
    public double getTotalPrice() {
        return getBasePrice() * getVolume();
    }
}
