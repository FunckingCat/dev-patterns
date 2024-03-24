package org.example.service;

import org.example.behavior.Beverage;
import org.example.factory.AddonFactory;
import org.example.factory.CocktailBeverageFactory;
import org.example.factory.FreshBeverageFactory;
import org.example.factory.SnackFactory;
import org.example.factory.TeaBeverageFactory;
import org.example.factory.VolumeFactory;
import org.example.model.Pair;
import org.example.model.Snack;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

public class OrderService {

    private final CocktailBeverageFactory cocktailBeverageFactory;
    private final FreshBeverageFactory freshBeverageFactory;
    private final TeaBeverageFactory teaBeverageFactory;

    public OrderService() {
        this.teaBeverageFactory = new TeaBeverageFactory();
        this.freshBeverageFactory = new FreshBeverageFactory();
        this.cocktailBeverageFactory = new CocktailBeverageFactory();
    }

    public Pair<Beverage, Snack> takeOrder(Scanner keyboard) {
        Map<Integer, String> menu = Map.of(
                0, "Cocktail",
                1, "Fresh",
                2, "Tea"
        );

        Map<String, Supplier<Beverage>> factories = Map.of(
                "Cocktail", () -> cocktailBeverageFactory.createBeverage(keyboard),
                "Fresh", () -> freshBeverageFactory.createBeverage(keyboard),
                "Tea", () -> teaBeverageFactory.createBeverage(keyboard)
        );

        System.out.println("CHOOSE BEVERAGE");

        List<String> output = menu.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> "[%d] - %s".formatted(entry.getKey(), entry.getValue()))
                .toList();
        System.out.println(String.join(" ", output));

        int input = keyboard.nextInt();

        Beverage beverage = factories.get(menu.get(input)).get();

        beverage = VolumeFactory.setVolume(beverage, keyboard);

        beverage = AddonFactory.addAddons(beverage, keyboard);

        return new Pair<>(beverage, SnackFactory.chooseSnack(keyboard));
    }

}
