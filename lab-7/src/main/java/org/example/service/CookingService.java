package org.example.service;

import org.example.behavior.Beverage;
import org.example.model.Pair;
import org.example.model.Snack;

import java.util.Arrays;

public class CookingService {

    public void cookOrder(Pair<Beverage, Snack> order) {

        System.out.printf("Cooking %s with ingredients:\n", order.getFirst().getDescription());
        order.getFirst().getIngredients().forEach(System.out::println);

        System.out.println("\nSTART COOKING BEVERAGE");
        order.getFirst().getRecipe().forEach(step -> {
            System.out.println(step);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Arrays.stream(order.getFirst().getDescription().split(","))
            .skip(1)
                .forEach(addon -> {
                    System.out.printf("Adding extra %s \n", addon.trim().replace("with", ""));
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });

        System.out.printf("Adding snack %s from snack storage to order\n", order.getSecond().getType().name());

    }

}
