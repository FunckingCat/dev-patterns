package org.example.behavior;

import java.util.List;

public interface Beverage {

    String getDescription();

    double getVolume();

    void setVolume(double volume);

    List<String> getRecipe();

    void setRecipe(List<String> recipe);

    List<String> getIngredients();

    void setIngredients(List<String> ingredients);

    double getTotalPrice();

}
