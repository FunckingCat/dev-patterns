package org.example;

import org.example.behavior.Beverage;
import org.example.factory.AbstractBeverageFactory;
import org.example.factory.CocktailFactory;
import org.example.factory.FreshFactory;
import org.example.factory.TeaFactory;
import org.example.factory.VolumeFactory;
import org.example.model.Cocktail;
import org.example.decorator.MilkDecorator;
import org.example.decorator.SugarDecorator;
import org.example.model.Tea;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        CocktailFactory cocktailFactory = new CocktailFactory();
        FreshFactory freshFactory = new FreshFactory();
        TeaFactory teaFactory = new TeaFactory();

        Map<Integer, String> menu = Map.of(
                0, "Cocktail",
                1, "Fresh",
                2, "Tea"
        );

        Map<String, Supplier<Beverage>> factories = Map.of(
                "Cocktail", () -> cocktailFactory.createBeverage(keyboard),
                "Fresh", () -> freshFactory.createBeverage(keyboard),
                "Tea", () -> teaFactory.createBeverage(keyboard)
        );

        List<String> output = menu.entrySet().stream()
                .map(entry -> "[%d] - %s".formatted(entry.getKey(), entry.getValue()))
                .toList();
        System.out.println(String.join(" ", output));
        int input = keyboard.nextInt();

        Beverage beverage = VolumeFactory.setVolume(factories.get(menu.get(input)).get(), keyboard);

        do {
            System.out.println("[0] Exit\n[1] +Milk\n[2] +Sugar");
            input = keyboard.nextInt();
            beverage = switch (input) {
                case 0 -> beverage;
                case 1 -> new MilkDecorator(beverage);
                case 2 -> new SugarDecorator(beverage);
                default -> throw new IllegalStateException("Unexpected value: " + input);
            };
        } while (input != 0);

        System.out.printf("Your choise: %s, %s Total cost %s\n", beverage.getDescription(), beverage.getVolume(), beverage.cost());

    }
}