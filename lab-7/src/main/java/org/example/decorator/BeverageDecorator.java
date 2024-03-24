package org.example.decorator;

import org.example.behavior.Beverage;

import java.util.List;

public abstract class BeverageDecorator implements Beverage {
    protected Beverage beverage;

    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription();
    }

    @Override
    public final double getVolume() {
        return beverage.getVolume();
    }

    @Override
    public final void setVolume(double volume) {
        beverage.setVolume(volume);
    }

    @Override
    public List<String> getRecipe() {
        return beverage.getRecipe();
    }

    @Override
    public void setRecipe(List<String> recipe) {
        beverage.setRecipe(recipe);
    }

    @Override
    public List<String> getIngredients() {
        return beverage.getIngredients();
    }

    @Override
    public void setIngredients(List<String> ingredients) {
        beverage.setIngredients(ingredients);
    }

    @Override
    public double getTotalPrice() {
        return beverage.getTotalPrice();
    }
}
