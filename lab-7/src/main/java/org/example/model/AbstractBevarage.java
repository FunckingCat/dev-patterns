package org.example.model;

import org.example.behavior.Beverage;

import java.util.List;

public abstract class AbstractBevarage implements Beverage {

    private final String type;

    private final String name;

    private double volume = 0.0;

    private float basePrice = 0.0f;

    @Override
    public List<String> getRecipe() {
        return recipe;
    }

    @Override
    public void setRecipe(List<String> recipe) {
        this.recipe = recipe;
    }

    @Override
    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    private List<String> recipe;

    private List<String> ingredients;

    public AbstractBevarage(String type, String name, List<String> recipe, List<String> ingredients, Float basePrice) {
        this.type = type;
        this.name = name;
        this.recipe = recipe;
        this.ingredients = ingredients;
        this.basePrice = basePrice;
    }

    public void setVolume(double volume){
        this.volume = volume;
    };

    public String getDescription() {
        return "%s %s".formatted(type, name);
    }

    @Override
    public double getVolume() {
        return volume;
    }

    public float getBasePrice() {
        return basePrice;
    }
}
