package org.example.factory;

import org.example.behavior.Beverage;
import org.example.model.Cocktail;
import org.example.model.Fresh;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FreshFactory extends AbstractBeverageFactory {

    public enum Type {
        APPLE, ORANGE;
    }

    @Override
    public Beverage createBeverage(Scanner input) {
        List<String> output = Arrays.stream(Type.values())
                .map(type -> "[%d] - %s".formatted(type.ordinal(), type.name().toLowerCase()))
                .toList();
        System.out.println(String.join(" ", output));
        int value = input.nextInt();
        return new Fresh(CocktailFactory.Type.values()[value].name());
    }
}
