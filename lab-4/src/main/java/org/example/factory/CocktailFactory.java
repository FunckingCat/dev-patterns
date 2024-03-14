package org.example.factory;

import org.example.behavior.Beverage;
import org.example.model.Cocktail;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CocktailFactory extends AbstractBeverageFactory {

    public enum Type {
        VANILLA, BERRY;
    }

    @Override
    public Beverage createBeverage(Scanner input) {
        List<String> output = Arrays.stream(Type.values())
                .map(type -> "[%d] - %s".formatted(type.ordinal(), type.name().toLowerCase()))
                .toList();
        System.out.println(String.join(" ", output));
        int value = input.nextInt();
        return new Cocktail(Type.values()[value].name());
    }
}
